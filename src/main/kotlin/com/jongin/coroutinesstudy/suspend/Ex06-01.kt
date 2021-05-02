package com.jongin.coroutinesstudy.suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    try {
        failedConcurrentSum()
    } catch (e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE) // Emulates very long computation
            42
        } finally {
            println("1 child was cancelled")
        }
    }

    val two = async<Int> {
        println("2 child throws an exception")
        throw ArithmeticException()
    }

    one.await() + two.await()
}

/**

1. 코루틴이 캔슬되면 캔슬된게 전파가 된다. => 전체 코루틴이 다 종료가 된다.
2. 2번째 코루틴에서 예외가 발생했는데, 1번째 코루틴에서 에서도 예외가 캐치되고, 부모에 코루틴에서도 예외가 캐치된다.
==> structured concurrency 형태에서 예외가 전파되고 => 다 종료, 리소스 해제를 해서 안전하게 종료할 수 있게끔 한다.

 **/
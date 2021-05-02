package com.jongin.coroutinesstudy.suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne2() }
        val two = async { doSomethingUsefulTwo2() }
        println("The answer is ${one.await() + two.await()}")
    }

    // 2초가 안걸린다!
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne2(): Int {
    delay(1000L)
    return 1
}

suspend fun doSomethingUsefulTwo2(): Int {
    delay(1000L)
    return 2
}

/**

1. 2개의 함수가 동시에 실행되도록 하면 더 빠르게 끝날 수 있지 않을까
async라는 것을 이용해서 호출하면 코루틴이 resume될 때 까지 기다리는게 아니라 바로 다음 라인으로 넘어간다.

2. await는 async가 끝날때까지 기다린다.

 **/
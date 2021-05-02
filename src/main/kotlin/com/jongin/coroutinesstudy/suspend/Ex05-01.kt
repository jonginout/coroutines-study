package com.jongin.coroutinesstudy.suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne7() }
    val two = async { doSomethingUsefulTwo7() }
    one.await() + two.await()
}

suspend fun doSomethingUsefulOne7(): Int {
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo7(): Int {
    delay(1000L)
    return 29
}

/**

1. 결국 suspend 함수로 또 만들어야 함
2. coroutineScope 스코프 안에서 suspend 함수를 조립해서 쓰면 된다.

 **/
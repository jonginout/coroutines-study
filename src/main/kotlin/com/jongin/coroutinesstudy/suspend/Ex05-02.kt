package com.jongin.coroutinesstudy.suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    try {
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum2()}")
        }
        println("Completed in $time ms")
    } catch (e: Exception) {
        e.printStackTrace()
    }

    runBlocking { delay(100000) }
}

suspend fun concurrentSum2(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne8() }
    val two = async { doSomethingUsefulTwo8() }

    delay(10)
    throw RuntimeException("이렇게 호출하면 상대적으로 안정적")

    one.await() + two.await()
}

suspend fun doSomethingUsefulOne8(): Int {
    println("doSomethingUsefulOne8 start")
    delay(3000)
    println("doSomethingUsefulOne8 end")
    return 13
}

suspend fun doSomethingUsefulTwo8(): Int {
    println("doSomethingUsefulTwo8 start")
    delay(3000)
    println("doSomethingUsefulTwo8 end")
    return 29
}

/**

1. exception 처리에서 안정적

 **/
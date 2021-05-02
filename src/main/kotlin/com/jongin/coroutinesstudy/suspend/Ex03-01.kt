package com.jongin.coroutinesstudy.suspend

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne3() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo3() }

        one.start()
        two.start()
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne3(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo3(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

/**

1. async로 호출하는 코루틴을 나중에 실행할 수 있을까?
 => CoroutineStart.LAZY 를 async 매개변수에 넣으면 start or await 할때 호출한다.

 **/
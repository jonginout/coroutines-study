package com.jongin.coroutinesstudy.suspend

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}

fun somethingUsefulOneAsync() = GlobalScope.async { doSomethingUsefulOne4() }

fun somethingUsefulTwoAsync() = GlobalScope.async { doSomethingUsefulTwo4() }

suspend fun doSomethingUsefulOne4(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo4(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

/**

1. async를 호출하는 라인까지 함수화 해서 더 간단하게 호출하고 싶다?
=> GlobalScope.async 를 한다.
=> 문제점 : exception이 발생할때 돌이킬 수 없는 상황이 나온다... 절대 하면 안된다. (다음 예제)
=> somethingUsefulOneAsync, somethingUsefulTwoAsync 결국 이건 일반 함수기 때문에 위험하다.
========>> structured concurrency 로 해결할 수 있다.


 **/
package com.jongin.coroutinesstudy.suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }

    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 1
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 2
}

/**

1. 유용한 기능을 순차적으로 2개 실행시키고 => 두개의 결과같을 더해보자

2. 실행을 순서대로 하고 싶으면?
=> 코루틴에서는 일반 코드처럼 작성하면 비동기일지라도 실행은 순차적으로 된다.

3. 일반 코드로 작성했고 / 메인 스레드에서 작성했지만 => main 스레드를 blocking 하지 않는다!

 **/
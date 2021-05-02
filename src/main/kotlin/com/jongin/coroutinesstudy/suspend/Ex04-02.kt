package com.jongin.coroutinesstudy.suspend

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    try {
        val time = measureTimeMillis {
            val one = somethingUsefulOneAsync2()
            val two = somethingUsefulTwoAsync2()

            throw Exception("에러가 발생했는데도 함수는 계속 동작해 ㅠㅠ")

            runBlocking {
                println("The answer is ${one.await() + two.await()}")
            }
        }

        println("Completed in $time ms")
    } catch (e: Exception) {
        e.printStackTrace()
    }

    runBlocking {
        delay(10000L)
    }
}

fun somethingUsefulOneAsync2() = GlobalScope.async {
    println("somethingUsefulOneAsync2 start ....")
    val result = doSomethingUsefulOne5()
    println("somethingUsefulOneAsync2 end ....")
    result
}

fun somethingUsefulTwoAsync2() = GlobalScope.async {
    println("somethingUsefulTwoAsync2 start ....")
    val result = doSomethingUsefulTwo6()
    println("somethingUsefulTwoAsync2 end ....")
    result
}

suspend fun doSomethingUsefulOne5(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo6(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

/**

1. exception이 발생할때 돌이킬 수 없는 상황이 나온다... 절대 하면 안된다.
=> exception이 발생했는데도... 그냥 함수는 계속 동작한다..
=> GlobalScope에서 발생한거라 지역에서 exception이 발생한거와 관련없이 계속 실행된다.


 **/
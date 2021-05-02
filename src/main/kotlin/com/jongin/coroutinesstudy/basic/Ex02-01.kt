package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    GlobalScope.launch {
        delay(1000L)
        println("World!!")
    }

    println("Hello,")

    runBlocking {
        delay(2000L)
    }
}

/**

    1. suspend 함수는 코루틴 스코프 혹은 다른 suspend 함수에서만 사용 가능하다.
    2. runBlocking 자신을 호출하는 스레드를 블로킹 한다. 반면 launch는 그렇지 않다.

 **/
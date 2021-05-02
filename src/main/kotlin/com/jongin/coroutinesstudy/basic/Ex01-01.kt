package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    // 코루틴은 코루틴 스코프 안에서 실행된다.
    // launch는 내부적으로 코루틴 하나를 반환한다. (코루틴 빌더)
    GlobalScope.launch {
        delay(1000L)
        println("World!!")
    }

    println("Hello,")
    Thread.sleep(2000L) // 1초뒤에 월드를 찍어야 하니깐 2초 뒤에 끝낸다.
}
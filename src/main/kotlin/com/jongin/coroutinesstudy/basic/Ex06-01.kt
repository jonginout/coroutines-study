package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {
        launch {
            myWorld()
        }

        println("Hello,")
    }

suspend fun myWorld() {
    delay(1000L)
    println("World!!")
}

/**

1. suspend 함수 만들기
suspend 함수는 suspend 함수나 코루틴 안에서만 호출 가능하다.
 **/
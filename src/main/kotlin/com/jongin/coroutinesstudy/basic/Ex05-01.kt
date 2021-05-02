package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {
        launch {
            delay(1000L)
            println("World!!")
        }

        println("Hello,")
    }

/**

1. [Structured concurrency]
 코루틴의 차일드로 코루틴을 만들면 부모 코루틴이 자식 코루틴을 기다려주기 때문에 join 할 필요 없다.
 **/
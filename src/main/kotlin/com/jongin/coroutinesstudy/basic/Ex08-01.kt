package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {
        GlobalScope.launch {
            repeat(1000) { i ->
                println("I'm sleeping $i")
                delay(500L)
            }
        }
        delay(1300L)
    }

/**
코루틴은 프로세스가 살아있을때만 동작이 가능하다.
 프로세스가 끝나면 코루틴도 죽는다.
 **/
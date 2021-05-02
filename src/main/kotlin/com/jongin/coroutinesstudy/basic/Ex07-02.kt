package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() =
    runBlocking {
        (0..100000).forEach { _ ->
            thread {
                Thread.sleep(1000L)
                print(".")
            }
        }
    }

/**
확실히 쓰레드보다 구조적으로 코루틴이 더 가볍다
 수가 더 많아지면 OOM 뜨지 않을까 싶다.
 **/
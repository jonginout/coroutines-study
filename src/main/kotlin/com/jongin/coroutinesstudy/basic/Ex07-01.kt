package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {
        (0..100000).forEach { _ ->
            launch {
                delay(1000L)
                print(".")
            }
        }
    }

/**
10만개의 점을 찍는데.. 속도가... 너무 빠르다
 **/
package com.jongin.coroutinesstudy.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done"
    }
    println("Result is $result")
}

/**

1. Timeout
=> exception 발생하지 않고 null 반

 **/
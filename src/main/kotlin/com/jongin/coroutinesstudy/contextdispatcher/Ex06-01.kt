package com.jongin.coroutinesstudy.contextdispatcher

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val request = launch {
        repeat(3) { i ->
            launch {
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
    println("Now processing of the request is complete")
}

/**

1. 부모 코루틴은 자식 코루틴이 끝날때 까지 기다려준다.
2. join 같은거 사용하지 않아도 부모 코루틴에서 자식 코루틴을 만들면 자식 코루틴이 끝날때 까지 기다린다.

 **/
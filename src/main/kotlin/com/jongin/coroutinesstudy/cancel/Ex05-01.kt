package com.jongin.coroutinesstudy.cancel

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")

    job.cancelAndJoin()
    println("main: Now I can quit.")
}

/**

1. 거의 잘 없는 케이스긴 하지만 이미 캔슬된 코루틴 내부에서 suspend 함수를 호출해야하는 경우?
 => finally 블록 안에서 다시 코루틴을 실행시켜야 하는 상황

 **/
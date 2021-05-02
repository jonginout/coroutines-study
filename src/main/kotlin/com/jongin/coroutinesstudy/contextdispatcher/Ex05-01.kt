package com.jongin.coroutinesstudy.contextdispatcher

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val request = launch {

        // 글로벌 스코프는 부모자식 관계가 없다.
        GlobalScope.launch {
            log("job1: I run in GlobalScope and execute independently!")
            delay(1000)
            log("job1: I am not affected by cancellation of the request")
        }

        launch {
            delay(100)
            log("job2: I am a child of the request coroutine")
            delay(1000)
            log("job2: I will not execute this line if my parent request is cancelled")
        }
    }

    delay(500)
    request.cancel()
    delay(1000)
    log("main: Who has survived request cancellation?")
}

/**

1. 부모 코루틴이 취소되었을때 자식 코루틴도 취소가 된다.
2. 다만 글로벌 스코프는 부모자식 관계가 없다.

 **/
package com.jongin.coroutinesstudy.cancel

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()

    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
//                    yield()
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")

    job.cancelAndJoin() // 내부적으로 exception을 발생시켜 종료한다.
    println("main: Now I can quit.")
}

/**

1. 코루틴이 취소 되어도 동작이 가능하다.??
=> 즉 조건에 따라서 취소가 가능하다.

2. 코루틴 취소가 되려면 => 코루틴 코드 자체에서 cancel이 가능한지 잘 체크를 해야 함 (취소하기 협조적인 코루틴)
=> suspend 함수는 취소 가능하다.
=> 즉 delay, yield 함수는 suspend 함수라 취소가 가능했다.



 **/
package com.jongin.coroutinesstudy.cancel

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()

    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        println("isActive ::::::::: $isActive")
        while (isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
        println("isActive ::::::::: $isActive")
    }

    delay(1300L)
    println("main: I'm tired of waiting!")

    job.cancelAndJoin() // 내부적으로 exception을 발생시켜 종료한다.
    println("main: Now I can quit.")
}

/**

1. 코루틴을 취소하기 위한 2가지 방법
 => 주기적으로 suspend 함수를 호출하면서 다시 재개 될 때 cancel이 된지 확인해서 exception을 던저주는 방식
 => 명시적으로 상태를 체크해서 상태가 isActive가 아니면 종료시키는 방식 => exception을 던지지 않는다.
 ==> isActive 잘 사용하면 좋다.

 **/
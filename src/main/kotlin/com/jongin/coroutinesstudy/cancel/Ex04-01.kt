package com.jongin.coroutinesstudy.cancel

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            // 여기서 해제
            println("job: I'm running finally")
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")

    job.cancelAndJoin()
    println("main: Now I can quit.")
}

/**

1. 코루틴을 종료할때 리소스를 종료하는 방식 및 위치가 어디가 좋을지?
 => exception이 발생되는 위치에서 해제 시켜주면 된다.

 **/
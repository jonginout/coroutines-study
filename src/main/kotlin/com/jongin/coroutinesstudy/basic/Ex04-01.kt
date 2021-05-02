package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {
        val job = GlobalScope.launch {
            delay(3000L)
            println("World!!")
        }

        println("Hello,")
        job.join()
    }

/**

1. 지금까지 2초를 기다린 이유는 launch 코루틴이 실행되는데 1초가 걸리니깐 2초 정도 기다려준건데
만약 코루틴이 실행되는데 3초가 넘게 걸린다면? 문제가 될 것 이다.

2. 그래서 launch가 반환하는 job을 join 하면 해당 코루틴이 끝날때까지 기다린다.

 **/
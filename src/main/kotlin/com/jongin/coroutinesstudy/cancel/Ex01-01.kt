package com.jongin.coroutinesstudy.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }

    delay(1300L)

    println("main: I'm tired of waiting!")

    job.cancel()
    job.join()

    println("main: Now I can quit.")
}

/**

1. job 객체는 실행되고 있는 코루틴을 취소할 수 있는 기능도 있다.
=> cancel

2. cancel이 없으면 1000번 찍히겠죠
3. join : launch가 반환하는 job을 join 하면 해당 코루틴이 끝날때까지 기다린다.


 즉, job은 취소가 가능하다.

 **/
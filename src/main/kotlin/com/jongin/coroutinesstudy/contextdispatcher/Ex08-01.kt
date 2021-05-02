package com.jongin.coroutinesstudy.contextdispatcher

import kotlinx.coroutines.*

class Activity {
    private val mainScope = CoroutineScope(Dispatchers.Default)

    fun destroy() {
        mainScope.cancel()
    }

    fun doSomething() {
        repeat(10) { i ->
            // 10개의 코루틴이 생김
            mainScope.launch {
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
    }
}

fun main() = runBlocking<Unit> {
    val activity = Activity()
    activity.doSomething()
    println("Launched coroutines")

    delay(500L)

    println("Destroying activity!")
    activity.destroy()
    delay(3000)
}

/**

1. 코루틴을 정상적으로 종료시키지 않으면 OOM이 날 가능성이 높다.
=> 코루틴 스코프를 이용해서 코루틴 스코프에서 모든 코루틴을 실행, 종료 시켜줄 수 있다.

ex) 여러개의 코루틴이 동작 하고 있는데 갑자기 화면을 나가면? => 모두 종료해줘야 함 안그러면 OOM

 **/
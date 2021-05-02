package com.jongin.coroutinesstudy.contextdispatcher

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    // 우리가 실행하려는 컨텍스트에서 Job이 있는지 꺼내봄
    println("My job is ${coroutineContext[Job]}")

    launch {
        println("My job is ${coroutineContext[Job]}")
    }

    async {
        println("My job is ${coroutineContext[Job]}")
    }

//    isActive 란 잡이 살아있는지 보는건데 사실상 아래와 같은 로직이다
//    coroutineContext[Job]?.isActive ?: true
}

/**

1. 코루틴 Context의 중요한 요소로 Dispatcher 말고도 Job이 있다.

 **/
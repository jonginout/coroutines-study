package com.jongin.coroutinesstudy.contextdispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    // 메인 스레드
    // 자신을 호출했던 코루틴 스코프에서 컨텍스트를 상속을 받아서 작업됨
    launch {
        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
    }

    // 메인 스레드
    launch(Dispatchers.Unconfined) {
        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
    }

    // 글로벌 스코프에서 실행했던 코루틴들이 실행되는 스레드가 Default 스레드
    launch(Dispatchers.Default) {
        println("Default               : I'm working in thread ${Thread.currentThread().name}")
    }

    // 코루틴을 실행할 때 마다 스레드를 하나씩 만드는 방식 => 매우 비추
    // use를 해서 꼭 close를 해줘야한다 아니면 OOM 가능성
    newSingleThreadContext("MyOwnThread")
        .use {
            launch(it) {
                println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
            }
        }
//    launch(newSingleThreadContext("MyOwnThread")) {
//        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
//    }
}

/**

1. 코루틴 Context
=> 코루틴은 항상 실행될때 코루틴 컨텍스트에서 실행된다.
=> 요소 : job, dispatcher ..

2. Dispatcher 와 Thread
=> 코루틴이 어떤 스레드나 어떤 스레드풀에서 실행될지를 결정해주는 요소

3. 코루틴 빌더는(ex. launch) 파라미터를 옵셔널로 하나 받는데 ==> 코루틴 컨텍스트 파라미터를 옵셔널로 받는다.
=> 명시적으로 dispatcher를 줄 수 있다.

4. Dispatcher는 코루틴이 어떤 스레드에서 실행될지 결정하는 엘리먼트 => 그 엘리먼트는 코루틴 컨텍스트에 저장된다.

 **/
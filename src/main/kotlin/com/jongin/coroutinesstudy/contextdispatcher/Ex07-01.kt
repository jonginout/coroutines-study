package com.jongin.coroutinesstudy.contextdispatcher

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}

/**

1. 코루틴 엘리먼트를 합치는 경우 Dispatchers.Default + CoroutineName("test")
여러개의 코루틴 엘리먼트를 전달하고 싶으면 + 를 하면 된다.

 **/
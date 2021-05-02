package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {

        launch {
            repeat(5) { i ->
                println("Coroutine A, $i")
                delay(10L)
            }
        }

        launch {
            repeat(5) { i ->
                println("Coroutine B, $i")
                delay(10L)
            }
        }

        println("Coroutine Outer")
    }

fun <T> println(msg: T) {
    kotlin.io.println("$msg (${Thread.currentThread().name})")
}

/**

일시중단 / 재개
suspend <-> resume 체험

VM option에 아래를 추가하면 쓰레드 확인시 어떤 코루틴에서 호출된건지 찍을 수 있다.
 -Dkotlinx.coroutines.debug

 찍어보니 코루틴 3개에서 실행됨
runBlocking / launch / launch 이렇게 3군데에서 코루틴이 만들어짐

 **/
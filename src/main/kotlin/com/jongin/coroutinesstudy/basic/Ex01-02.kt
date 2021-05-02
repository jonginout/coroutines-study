package com.jongin.coroutinesstudy.basic

import kotlin.concurrent.thread

fun main() {

    // launch를 일반적인 Thread로 바꿔보자
    // 결과가 똑같다
    // 스레드와 코루틴은 비슷한건가??
    thread {
        Thread.sleep(2000L)
        println("World!!")
    }

    println("Hello,")
    Thread.sleep(2000L)
}

/**

 1. 프로그램 순서는 월드 헬로우 이렇게 찍힐 것 같은데 -> 헬로우 월드가 찍힌다?
 2. 기본적으로 코루틴은 light-wight threads 다.
 3. launch 코루틴 빌더
    -> 런치를 사용하기 위해서는 스코프가 필요하다.
    -> 여기서는 GlobalScope를 사용했다.

 4. delay : suspend 함수 -> 일시중단 함수
    Thread.sleep : 쓰레드를 blocking 하는 함수

 **/
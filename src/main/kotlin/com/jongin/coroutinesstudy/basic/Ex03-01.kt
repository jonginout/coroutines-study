package com.jongin.coroutinesstudy.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {
        GlobalScope.launch {
            delay(1000L)
            println("World!!")
        }

        println("Hello,")

        delay(2000L)
    }

/**

1. 함수 코드 전체를 runBlocking 감싸는게 조금더 `관용적`인 코드다
2. 전체 코드들이 다 실행되기 전까지는 메인스레드가 runBlocking 때문에 리턴이 안된다.

 **/
package com.jongin.coroutinesstudy.contextdispatcher

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                log("Started in ctx1")

                // 스레드 스위칭
                withContext(ctx2) {
                    log("Working in ctx2")
                }

                log("Back to ctx1")
            }
        }
    }
}

/**

1. 코루틴이 스레드를 스위칭 하는
- 메인스레드에서 뭔가 처리하고 백그라운드 스레드 갔다가 메인스레드로 오게끔 할때 사용하면 좋을 듯?

 **/
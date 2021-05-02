package com.jongin.coroutinesstudy.contextdispatcher

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun log(msg: String) = println("$msg                [${Thread.currentThread().name}]")

fun main() = runBlocking<Unit> {
    val a = async {
        log("I'm computing a piece of the answer")
        6
    }

    val b = async {
        log("I'm computing another piece of the answer")
        7
    }

    log("The answer is ${a.await() * b.await()}")
}

/**

-Dkotlinx.coroutines.debug

 **/
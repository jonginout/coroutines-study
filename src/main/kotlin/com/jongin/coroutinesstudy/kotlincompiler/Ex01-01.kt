package com.jongin.coroutinesstudy.kotlincompiler

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(): Unit {
    GlobalScope.launch {
        val userData = fetchUserData()
        val userCache = cacheUserData(userData)
        updateTextView2(userCache)
    }
}

suspend fun fetchUserData() = "user_name"

suspend fun cacheUserData(user: String) = user

fun updateTextView2(user: String) = user

/**

 tools > kotlin > show kotlin bytecode > decomplied

 **/
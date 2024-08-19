package com.example.weatherappmy.data.util

import com.example.weatherappmy.domain.util.Result


suspend inline fun <T> safeCall(crossinline call: suspend () -> T): Result<T> {
    return try {
        Result.Success(call())
    } catch (e: Exception) {
        Result.Failure(e)
    }
}
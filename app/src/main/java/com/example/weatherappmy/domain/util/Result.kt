package com.example.weatherappmy.domain.util

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Failure(val error: Throwable) : Result<Nothing>()
}
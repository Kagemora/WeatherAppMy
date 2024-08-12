package com.example.weatherappmy.domain.util

sealed class NetworkError : Exception() {
    object NoInternet : NetworkError()
    object ServerError : NetworkError()
    data class UnknownError(override val message: String?) : NetworkError()
}
package com.example.weatherappmy.domain.util

sealed class DatabaseError : Exception() {
    data class UnknownError(override val message: String?) : DatabaseError()
}
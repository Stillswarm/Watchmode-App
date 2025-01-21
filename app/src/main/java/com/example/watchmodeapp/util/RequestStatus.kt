package com.example.watchmodeapp.util

sealed class RequestStatus<out T> {
    object Idle : RequestStatus<Nothing>()
    object Loading : RequestStatus<Nothing>()
    data class Success<out T>(val data : T) : RequestStatus<T>()
    data class Error(val msg: String) : RequestStatus<Nothing>()
}
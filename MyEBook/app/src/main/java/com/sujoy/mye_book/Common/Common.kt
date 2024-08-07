package com.sujoy.mye_book.Common

sealed class ResultState<out T>{
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error<T>(val exception: Throwable) : ResultState<T>()
    object Loading : ResultState<Nothing>()
}
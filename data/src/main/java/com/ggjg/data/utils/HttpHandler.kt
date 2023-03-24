package com.ggjg.data.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend inline fun <T> GGJGApiCall(
    crossinline callFunction: suspend () -> T,
): T {
    return try {
        withContext(Dispatchers.IO) {
            callFunction()
        }
    } catch (e: HttpException) {
        throw e
    }
}
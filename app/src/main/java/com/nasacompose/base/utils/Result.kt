package com.nasacompose.base.utils

import retrofit2.Response
import java.io.IOException

suspend fun <T> getResult(responseCall: suspend () -> Response<T>): Resource<T> {

   /* if (!networkConnectivity.isConnected()) {
        return NO_INTERNET_CONNECTION
    }*/
    return try {
        var response = responseCall()
        var data = response?.body()
        //val code = response.code()

        Resource.Success(data)

    } catch (e: IOException) {

        Resource.Error(e.localizedMessage)
    }
}

suspend fun <T> getResource(responseCall: suspend () -> T?): Resource<T> {

    return try {
        var response = responseCall()

        Resource.Success(response)

    } catch (e: IOException) {

        Resource.Error(e.localizedMessage)
    }
}
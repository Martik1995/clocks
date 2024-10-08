package com.mmg.clocks.shared.network

import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

internal class ResultCall<T>(
    proxy: Call<T>
) : CallDelegate<T, T>(proxy) {

    override fun enqueueImpl(callback: Callback<T>) {
        proxy.enqueue(ResultCallback(this, callback))
    }

    override fun executeImpl(): Response<T> {
        return proxy.execute()
    }

    override fun cloneImpl(): ResultCall<T> {
        return ResultCall(proxy.clone())
    }

    private inner class ResultCallback<T>(
        private val proxy: Call<T>,
        private val callback: Callback<T>,
    ) : Callback<T> {

        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                onResponseSuccess(response)
            } else {
                onResponseFailure(response)
            }
        }

        @Suppress("UNCHECKED_CAST")
        private fun onResponseSuccess(response: Response<T>) {
            val result = response.body() as T
            callback.onResponse(proxy, Response.success(result))
        }

        private fun onResponseFailure(response: Response<T>) {
            callback.onFailure(proxy, HttpException(response))
        }

        override fun onFailure(call: Call<T>, throwable: Throwable) {
            val result = when (throwable) {
                is SocketTimeoutException -> DomainError.Timeout(throwable)
                is IOException -> DomainError.Network(throwable)
                else -> DomainError.Unknown(throwable)
            }

            callback.onFailure(proxy, result)
        }

    }

    override fun timeout(): Timeout {
        return proxy.timeout()
    }
}
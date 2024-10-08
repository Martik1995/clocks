package com.mmg.clocks.shared.network

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class CallAdapterFactory : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        val rawReturnType: Class<*> = getRawType(returnType)
        if (rawReturnType == Call::class.java) {
            if (returnType is ParameterizedType) {
                val callInnerType: Type = getParameterUpperBound(0, returnType)
                return ResultCallAdapter<Any?>(callInnerType)
            }
            return ResultCallAdapter<Nothing>(Nothing::class.java)
        }
        return null
    }

    private inner class ResultCallAdapter<R>(private val type: Type) : CallAdapter<R, Call<R>> {

        override fun responseType() = type

        override fun adapt(call: Call<R>): Call<R> = ResultCall(call)
    }
}
package com.mmg.clocks.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mmg.clocks.shared.network.CallAdapterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

private const val TIMEOUT_IN_SEC = 180L
private const val BASE_URL = "https://www.timeapi.io/"
private const val CONTENT_TYPE = "application/json"

@OptIn(ExperimentalSerializationApi::class)
val networkModule = module {

    single {
        Json {
            isLenient = true
            coerceInputValues = true
            ignoreUnknownKeys = true
        }
    }

    single {
        val client = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CallAdapterFactory())
            .addConverterFactory(get<Json>().asConverterFactory(CONTENT_TYPE.toMediaType()))
            .client(client)
            .build()
    }
}
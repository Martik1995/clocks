package com.mmg.clocks.data.network

import com.mmg.clocks.data.entity.TimeObj
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    /**
     * Запрос на получение времени города (@param code/код города)
     */
    @GET("api/time/current/zone")
    suspend fun getTimeByCityCode(@Query("timeZone") code: String): TimeObj
}
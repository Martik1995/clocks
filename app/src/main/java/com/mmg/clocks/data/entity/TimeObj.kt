package com.mmg.clocks.data.entity

import com.mmg.clocks.domain.data.Time
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimeObj(
    @SerialName("hour") val hour: Long? = null,
    @SerialName("minute") val minute: Long? = null,
    @SerialName("seconds") val seconds: Long? = null,
) {
    companion object {
        fun TimeObj.toDomain() = Time(
            hour = hour ?: 0,
            minute = minute ?: 0,
            seconds = seconds ?: 0
        )
    }
}
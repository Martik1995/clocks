package com.mmg.clocks.data.entity

import com.mmg.clocks.domain.data.City
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityObj(
    @SerialName("name") val name: String? = null,
    @SerialName("code") val code: String? = null
) {
    companion object {
        fun CityObj.toDomain() = City(
            name ?: "",
            code ?: ""
        )
    }
}
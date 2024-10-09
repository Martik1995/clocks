package com.mmg.clocks.domain.data

import com.mmg.clocks.data.entity.CityObj

data class City(val name: String, val code: String) {
    companion object {
        fun City.toObj() = CityObj(
            name = name,
            code = code
        )
    }
}
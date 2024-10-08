package com.mmg.clocks.presentation.data

data class Country(val name: String, val code: String) {
    companion object {
        fun getMockList() = listOf(
            Country("London", "Europe/London"),
            Country("Moscow", "Europe/Moscow"),
            Country("Warsaw", "Europe/Warsaw"),
            Country("HongKong", "Hongkong"),
            Country("Toronto", "America/Toronto")
        )
    }
}

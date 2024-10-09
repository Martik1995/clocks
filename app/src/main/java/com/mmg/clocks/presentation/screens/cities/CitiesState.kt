package com.mmg.clocks.presentation.screens.cities

import com.mmg.clocks.domain.data.City
import com.mmg.clocks.presentation.base.BaseDataState

data class CitiesState(
    val cities: List<City> = emptyList()
) : BaseDataState
package com.mmg.clocks.presentation.screens.cities

import com.mmg.clocks.domain.data.City
import com.mmg.clocks.presentation.base.BaseEvent

sealed class CitiesEvent : BaseEvent {
    data class CitySelected(val city: City) : CitiesEvent()
}
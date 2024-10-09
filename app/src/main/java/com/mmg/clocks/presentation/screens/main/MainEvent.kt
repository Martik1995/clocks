package com.mmg.clocks.presentation.screens.main

import com.mmg.clocks.presentation.base.BaseEvent
import com.mmg.clocks.domain.data.City

sealed class MainEvent : BaseEvent {
    data class NewCitySelected(val city: City) : MainEvent()
    data object OpenCitiesList : MainEvent()
}
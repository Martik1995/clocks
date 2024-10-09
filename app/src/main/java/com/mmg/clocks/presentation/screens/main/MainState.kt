package com.mmg.clocks.presentation.screens.main

import com.mmg.clocks.presentation.base.BaseDataState
import com.mmg.clocks.domain.data.City

data class MainState(
    val selectedCity: City = City("", ""),
    val time: String = "",
    val timerEnabled: Boolean = false
) : BaseDataState
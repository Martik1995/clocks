package com.mmg.clocks.presentation.screens.main

import BaseViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.mmg.clocks.domain.repository.IRepository
import com.mmg.clocks.navigation.Screen
import com.mmg.clocks.presentation.base.BaseEvent
import com.mmg.clocks.shared.utils.SEC
import com.mmg.clocks.shared.utils.addSecondToTimer
import com.mmg.clocks.shared.utils.bindTimerText
import com.mmg.clocks.shared.utils.launchWithCatch
import kotlinx.coroutines.delay

class MainViewModel(
    private val navHostController: NavHostController,
    private val repository: IRepository
) : BaseViewModel<MainState>() {
    override fun createDefaultDataState(): MainState {
        return MainState()
    }

    init {
        handleLoadData()
    }

    override fun reduce(event: BaseEvent) {
        when (event) {

            is MainEvent.OpenCitiesList -> {
                navHostController.navigate(Screen.Cities.route)
            }

            is MainEvent.NewCitySelected -> {
                handleLoadData()
            }

        }
    }

    private fun handleLoadData() {
        createRequest {
            val selectedCity = repository.getSelectedCity()
            updateDataWithState { dataState ->
                dataState.copy(selectedCity = selectedCity, timerEnabled = false, time = "")
            }
            repository.getTimeByCityCode(selectedCity.code)
        }.launch(
            onData = { result ->
                val time = bindTimerText(h = result.hour, m = result.minute, s = result.seconds)
                updateData(getStateData().copy(time = time, timerEnabled = true))
                startTimerOf()
            }
        )
    }

    private fun startTimerOf() {
        viewModelScope.launchWithCatch {
            while (true) {
                val currentTime = getStateData().time
                val newTime = addSecondToTimer(currentTime)
                updateData(getStateData().copy(time = newTime))
                if (!getStateData().timerEnabled) break
                delay(SEC)
            }
        }
    }
}
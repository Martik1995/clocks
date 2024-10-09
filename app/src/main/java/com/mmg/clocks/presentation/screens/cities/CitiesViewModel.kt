package com.mmg.clocks.presentation.screens.cities

import BaseViewModel
import androidx.navigation.NavHostController
import com.mmg.clocks.domain.repository.IRepository
import com.mmg.clocks.navigation.Screen
import com.mmg.clocks.presentation.base.BaseEvent


class CitiesViewModel(
    private val navHostController: NavHostController,
    private val repository: IRepository
) : BaseViewModel<CitiesState>() {
    override fun createDefaultDataState(): CitiesState {
        return CitiesState()
    }

    init {
        loadData()
    }


    override fun reduce(event: BaseEvent) {
        when (event) {
            is CitiesEvent.CitySelected -> {
                repository.saveSelectedCity(event.city)
                navHostController.popBackStack(Screen.Main.route, inclusive = true)
                navHostController.navigate(Screen.Main.route)
            }
        }
    }

    private fun loadData() {
        createRequest {
            repository.getCities()
        }.launch { result ->
            updateDataWithState { currentState: CitiesState ->
                currentState.copy(cities = result)
            }
        }
    }
}

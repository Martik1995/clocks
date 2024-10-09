package com.mmg.clocks.presentation.screens.cities

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mmg.clocks.presentation.base.BaseScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CitiesScreen(
    navController: NavHostController,
    viewModel: CitiesViewModel = koinViewModel(
        parameters = { parametersOf(navController) }
    )
) {
    BaseScreen(
        viewModel = viewModel,
        loader = null,
        data = { state, _ ->
            LazyColumn {
                items(state.cities) { city ->
                    CityItem(city) {
                        viewModel.onUIEvent(CitiesEvent.CitySelected(city))
                    }
                    HorizontalDivider()
                }
            }
        })
}
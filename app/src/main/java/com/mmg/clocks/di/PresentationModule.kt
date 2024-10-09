package com.mmg.clocks.di

import com.mmg.clocks.presentation.screens.cities.CitiesViewModel
import com.mmg.clocks.presentation.screens.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.ParametersHolder
import org.koin.dsl.module

val presentationModule = module {
    viewModel<MainViewModel> { parametersHolder: ParametersHolder ->
        MainViewModel(navHostController = parametersHolder.get(), repository = get())
    }

    viewModel<CitiesViewModel> { parametersHolder: ParametersHolder ->
        CitiesViewModel(navHostController = parametersHolder.get(), repository = get())
    }
}
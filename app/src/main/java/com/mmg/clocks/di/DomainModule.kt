package com.mmg.clocks.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import com.mmg.clocks.data.local.PreferencesImpl
import com.mmg.clocks.data.repository.RepositoryImpl
import com.mmg.clocks.domain.local.IPreferences
import com.mmg.clocks.domain.repository.IRepository
import org.koin.dsl.module

private const val PREFERENCES_KEY = "ClocksPreferences"
val domainModule = module {

    single<IPreferences> {
        val sharedPreferences =
            androidContext().getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE)
        PreferencesImpl(json = get(), sharedPreferences = sharedPreferences)
    }

    single<IRepository> { RepositoryImpl(api = get(), preferences = get()) }
}
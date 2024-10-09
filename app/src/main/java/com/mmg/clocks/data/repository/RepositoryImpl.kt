package com.mmg.clocks.data.repository

import com.mmg.clocks.data.entity.CityObj
import com.mmg.clocks.data.entity.CityObj.Companion.toDomain
import com.mmg.clocks.data.entity.TimeObj.Companion.toDomain
import com.mmg.clocks.data.network.Api
import com.mmg.clocks.domain.data.City
import com.mmg.clocks.domain.data.City.Companion.toObj
import com.mmg.clocks.domain.data.Time
import com.mmg.clocks.domain.local.CITY_KEY
import com.mmg.clocks.domain.local.IPreferences
import com.mmg.clocks.domain.repository.IRepository

class RepositoryImpl(
    private val api: Api,
    private val preferences: IPreferences
) : IRepository {
    override fun saveSelectedCity(city: City) {
        val obj = city.toObj()
        preferences.putObject(CITY_KEY, obj, CityObj.serializer())
    }

    override fun getSelectedCity(): City {
        val selectedCity =
            preferences.getObject(CITY_KEY, CityObj.serializer())?.toDomain() ?: citiesList().first()
        return selectedCity
    }

    override fun getCities(): List<City> {
        return citiesList()
    }

    override suspend fun getTimeByCityCode(code: String): Time {
        return api.getTimeByCityCode(code).toDomain()
    }

}

private fun citiesList() = listOf(
    City("London", "Europe/London"),
    City("Moscow", "Europe/Moscow"),
    City("Warsaw", "Europe/Warsaw"),
    City("HongKong", "Hongkong"),
    City("Toronto", "America/Toronto")
)
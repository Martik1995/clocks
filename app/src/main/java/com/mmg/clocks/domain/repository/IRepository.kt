package com.mmg.clocks.domain.repository

import com.mmg.clocks.domain.data.City
import com.mmg.clocks.domain.data.Time

interface IRepository {

    /**
     * Сохраняем выбранный город
     */
    fun saveSelectedCity(city: City)

    /**
     * Возвращает выбранный город (по дэфолту возвращаем из списка 1ый объект)
     */
    fun getSelectedCity(): City

    /**
     * Возвращает список городов (мок дата)
     */
    fun getCities(): List<City>

    /**
     * Возвращает время по выбранному городу (отправляем @param code city объекта)
     */
    suspend fun getTimeByCityCode(code: String): Time
}
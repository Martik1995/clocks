package com.mmg.clocks.domain.local

import kotlinx.serialization.KSerializer

/**
 * Интерфейс для работы с кэш-датами
 */

const val CITY_KEY = "CityKey"

interface IPreferences {
    fun <Type> putObject(key: String, obj: Type, serializer: KSerializer<Type>)
    fun <Type> getObject(key: String, serializer: KSerializer<Type>): Type?
}
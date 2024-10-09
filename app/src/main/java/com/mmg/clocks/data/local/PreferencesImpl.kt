package com.mmg.clocks.data.local

import android.content.SharedPreferences
import com.mmg.clocks.domain.local.IPreferences
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class PreferencesImpl(
    private val sharedPreferences: SharedPreferences,
    private val json: Json
) : IPreferences {

    override fun <Type> putObject(key: String, obj: Type, serializer: KSerializer<Type>) {
        val jsonString = json.encodeToString(serializer, obj)
        sharedPreferences.edit().putString(key, jsonString).apply()
    }

    override fun <Type> getObject(key: String, serializer: KSerializer<Type>): Type? {
        val jsonString = sharedPreferences.getString(key, null) ?: return null
        return json.decodeFromString(serializer, jsonString)
    }
}
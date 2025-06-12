package com.kamalnathvg.mobirr.data_core

import kotlinx.coroutines.flow.Flow


interface Storage{

    fun <T> getAsFlow(key: Key<T>): Flow<T?>

    suspend fun <T> get(key: Key<T>): T?

    suspend fun <T> writeValue(key: Key<T>, value: T?)

    suspend fun <T> clearValue(key: Key<T>){
        writeValue(key, null)
    }

    sealed class Key<T>(
        val name: String,
        val defaultValue: T?,
    ){
        class StringKey(name: String, defaultValue: String?): Key<String>(name, defaultValue)
        class IntKey(name: String, defaultValue: Int?): Key<Int>(name, defaultValue)
        class LongKey(name: String, defaultValue: Long?): Key<Long>(name, defaultValue)
        class FloatKey(name: String, defaultValue: Float?): Key<Float>(name, defaultValue)
        class DoubleKey(name: String, defaultValue: Double?): Key<Double>(name, defaultValue)
        class BooleanKey(name: String, defaultValue: Boolean?): Key<Boolean>(name, defaultValue)
    }

    //TODO: move this to a separate file later on
    companion object Keys{
        const val RADARR_API_TOKEN = "radarrApiKey"
    }
}
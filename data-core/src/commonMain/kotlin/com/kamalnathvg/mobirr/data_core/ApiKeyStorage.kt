package com.kamalnathvg.mobirr.data_core

interface ApiKeyStorage {
    fun getRadarrApiKey(): String?
    fun setRadarrApiKey(apiKey: String)
}

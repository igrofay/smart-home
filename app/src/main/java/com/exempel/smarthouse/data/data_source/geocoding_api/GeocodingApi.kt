package com.exempel.smarthouse.data.data_source.geocoding_api

import com.exempel.smarthouse.data.model.geo_data.GeoData
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class GeocodingApi @Inject constructor(
    private val client: HttpClient,
) {
    private val defaultParameters = "?format=json&apiKey=949e407f32254495ac0aff166c6b8b71"
    suspend fun getAddressFromPoint(lang: String, lat: Double, lon: Double): GeoData{
        return client
            .get("https://api.geoapify.com/v1/geocode/reverse?lat=$defaultParameters&$lat&lon=$lon&lang=$lang")
            .body()
    }
}
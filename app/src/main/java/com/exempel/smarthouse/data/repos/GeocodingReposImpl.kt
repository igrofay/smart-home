package com.exempel.smarthouse.data.repos

import com.exempel.smarthouse.data.data_source.geocoding_api.GeocodingApi
import com.exempel.smarthouse.domain.model.error.ErrorRequest
import com.exempel.smarthouse.domain.repos.GeocodingRepos
import java.util.*
import javax.inject.Inject


class GeocodingReposImpl @Inject constructor(
    private val geocodingApi: GeocodingApi,
): GeocodingRepos {
    private val lang
        get() = Locale.getDefault().language
    override suspend fun addressFromPoint(lat: Double, lon: Double): String {
        try {
            val answer = geocodingApi.getAddressFromPoint(lang, lat, lon).results.firstOrNull()
                ?: throw ErrorRequest.DataNotFound()
            return answer.address_line2
        }catch (e: Exception){
            throw ErrorRequest.DataNotFound()
        }
    }
}
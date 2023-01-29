package com.exempel.smarthouse.data.repos

import android.util.Log
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
            return answer.formatted
        }catch (e: Exception){
            Log.e(e.toString(), e.message.toString())
            throw ErrorRequest.DataNotFound()
        }
    }
}
package com.exempel.smarthouse.domain.repos

interface GeocodingRepos {
    suspend fun addressFromPoint(lat: Double, lon: Double,): String
}
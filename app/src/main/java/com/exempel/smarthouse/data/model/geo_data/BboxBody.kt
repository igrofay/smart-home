package com.exempel.smarthouse.data.model.geo_data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BboxBody(
    @SerialName("lat1")
    val lat1: Double,
    @SerialName("lat2")
    val lat2: Double,
    @SerialName("lon1")
    val lon1: Double,
    @SerialName("lon2")
    val lon2: Double
)
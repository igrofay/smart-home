package com.exempel.smarthouse.data.model.geo_data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoDataBody(
    @SerialName("results")
    val results: List<ResultBody>
)
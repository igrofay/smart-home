package com.exempel.smarthouse.data.model.geo_data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RankBody(
    @SerialName("importance")
    val importance: Double,
    @SerialName("popularity")
    val popularity: Double
)
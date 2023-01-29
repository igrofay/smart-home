package com.exempel.smarthouse.data.model.geo_data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimezoneBody(
    @SerialName("name")
    val name: String,
    @SerialName("offset_DST")
    val offsetDST: String,
    @SerialName("offset_DST_seconds")
    val offsetDSTSeconds: Int,
    @SerialName("offset_STD")
    val offsetSTD: String,
    @SerialName("offset_STD_seconds")
    val offsetSTDSeconds: Int
)
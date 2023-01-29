package com.exempel.smarthouse.data.model.geo_data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DatasourceBody(
    @SerialName("attribution")
    val attribution: String,
    @SerialName("license")
    val license: String,
    @SerialName("sourcename")
    val sourcename: String,
    @SerialName("url")
    val url: String
)
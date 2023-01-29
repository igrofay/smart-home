package com.exempel.smarthouse.data.model.geo_data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultBody(
    @SerialName("address_line1")
    val addressLine1: String,
    @SerialName("address_line2")
    val addressLine2: String,
    @SerialName("bbox")
    val bbox: BboxBody,
    @SerialName("category")
    val category: String,
    @SerialName("city")
    val city: String,
    @SerialName("country")
    val country: String,
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("county")
    val county: String,
    @SerialName("datasource")
    val datasource: DatasourceBody,
    @SerialName("distance")
    val distance: Double,
    @SerialName("district")
    val district: String,
    @SerialName("formatted")
    val formatted: String,
    @SerialName("housenumber")
    val housenumber: String,
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double,
    @SerialName("name")
    val name: String? = null,
    @SerialName("place_id")
    val placeId: String,
    @SerialName("postcode")
    val postcode: String,
    @SerialName("rank")
    val rank: RankBody,
    @SerialName("region")
    val region: String,
    @SerialName("result_type")
    val resultType: String,
    @SerialName("state")
    val state: String,
    @SerialName("street")
    val street: String,
    @SerialName("timezone")
    val timezone: TimezoneBody
)
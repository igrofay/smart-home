package com.exempel.smarthouse.data.model.geo_data

data class Result(
    val address_line1: String,
    val address_line2: String,
    val bbox: Bbox,
    val category: String,
    val city: String,
    val country: String,
    val country_code: String,
    val datasource: Datasource,
    val distance: Int,
    val district: String,
    val formatted: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val place_id: String,
    val rank: Rank,
    val result_type: String,
    val street: String,
    val suburb: String,
    val timezone: Timezone
)
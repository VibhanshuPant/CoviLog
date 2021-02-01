package com.project.covilog.Models

import com.google.gson.annotations.SerializedName

data class CountryListItem(
    @SerializedName("active")
    val active: Int,
    @SerializedName("cases")
    val cases: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("countryInfo")
    val countryInfo: CountryInfo,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("recovered")
    val recovered: Int,




    )
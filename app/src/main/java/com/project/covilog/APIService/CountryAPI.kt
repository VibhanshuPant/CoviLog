package com.project.covilog.APIService

import com.project.covilog.Models.CountryList
import retrofit2.Call
import retrofit2.http.GET

interface CountryAPI {
    @GET("countries")
    fun getCountryList(): Call<CountryList>
}
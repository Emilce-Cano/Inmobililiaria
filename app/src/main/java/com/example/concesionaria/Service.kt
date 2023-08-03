package com.example.concesionaria

import com.example.concesionaria.data.EnvironmentDetailsResponse
import com.example.concesionaria.data.HousesEnvironmentResponse
import retrofit2.http.GET

interface Service {
    @GET("/houses")
    suspend fun getRandomHouse(): HousesEnvironmentResponse

    @GET("/houses/environment/detail/{id}")
    suspend fun getDetailsHouse(): EnvironmentDetailsResponse
}

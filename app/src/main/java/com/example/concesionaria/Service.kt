package com.example.concesionaria

import com.example.concesionaria.data.HousesEnvironmentResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("/houses")

    suspend fun getRandomHouse(): HousesEnvironmentResponse

    @GET("/houses/environment/{id}")

    suspend fun getEnvironment(@Path("{id}") id: String): HousesEnvironmentResponse

}

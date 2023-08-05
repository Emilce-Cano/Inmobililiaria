package com.example.concesionaria.model.service

import com.example.concesionaria.model.dto.EnvironmentDetailsResponse
import com.example.concesionaria.model.dto.HousesEnvironmentResponse
import com.example.concesionaria.model.dto.HousesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("houses")
    suspend fun getAllHouses(): Response<HousesResponse>

    @GET("houses/environment/detail/{id}")
    suspend fun getDetailsHouse(@Path("{id}") id: String): EnvironmentDetailsResponse

    @GET("houses/environment/{id}")
    suspend fun getEnvironment(@Path("{id}") id: String): HousesEnvironmentResponse


}

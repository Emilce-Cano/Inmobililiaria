package com.example.concesionaria.model.repository

import com.example.concesionaria.model.dto.EnvironmentDetailsResponse
import com.example.concesionaria.model.dto.HousesEnvironmentResponse
import com.example.concesionaria.model.dto.HousesResponse
import com.example.concesionaria.model.service.Service
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Repository {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://stoplight.io/mocks/refactoringlife/refactoringlife/218091855/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var serviceImp = retrofit.create<Service>()

    suspend fun getHouses(): Response<HousesResponse> {
        return serviceImp.getAllHouses()
    }

    suspend fun getEnvironment(id: String): HousesEnvironmentResponse {
        return serviceImp.getEnvironment(id)
    }

    suspend fun getDetails(id: String): EnvironmentDetailsResponse {
        return serviceImp.getDetailsHouse(id)
    }
}

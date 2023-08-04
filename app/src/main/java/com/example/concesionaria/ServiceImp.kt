package com.example.concesionaria

import com.example.concesionaria.data.HousesEnvironmentResponse
import com.example.concesionaria.data.HousesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ServiceImp {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://stoplight.io/mocks/refactoringlife/refactoringlife/218091855/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var serviceImp = retrofit.create<Service>()

    suspend fun getHouses(): HousesResponse {
        return serviceImp.getAllHouses()
    }

    suspend fun getEnvironment(id: String): HousesEnvironmentResponse {
        return serviceImp.getEnvironment(id)
    }
}

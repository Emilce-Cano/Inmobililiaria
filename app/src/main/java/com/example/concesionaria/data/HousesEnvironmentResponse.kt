package com.example.concesionaria.data

data class HousesEnvironmentResponse(
    val state: String,
    val description: String,
    val images: List<ImageHouseData>
)
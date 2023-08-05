package com.example.concesionaria.model.dto

data class HousesEnvironmentResponse(
    val state: String,
    val description: String,
    val images: List<ImageHouseData>
)

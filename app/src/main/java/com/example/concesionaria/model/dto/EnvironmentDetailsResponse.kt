package com.example.concesionaria.model.dto

data class EnvironmentDetailsResponse(
    val measures: String,
    val color: String,
    val images: List<Image>

) {
    data class Image(
        val image: String

)
}

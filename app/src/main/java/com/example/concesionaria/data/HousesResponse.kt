package com.example.concesionaria.data

data class HousesResponse(
   val houses: List<Data>
){
   data class Data(
      val id: String,
      val coste: String,
      val money: String,
      val image:String
   )
}



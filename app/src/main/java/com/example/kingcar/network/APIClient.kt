package com.example.kingcar.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object APIClient {
    private const val BASE_URL = "http://43.201.24.249:8080/"

    val client: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
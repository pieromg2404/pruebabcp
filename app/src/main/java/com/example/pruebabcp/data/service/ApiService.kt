package com.example.pruebabcp.data.service

import retrofit2.http.GET
import com.example.pruebabcp.data.model.ApiResponse

interface ApiService {
    @GET("objects")
    suspend fun getDevices(): List<ApiResponse>
}

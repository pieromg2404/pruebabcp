package com.example.pruebabcp.data.datasource

import com.example.pruebabcp.domain.model.DeviceDomainModel
import com.example.pruebabcp.data.model.ApiResponse
import com.example.pruebabcp.data.model.toDomain
import com.example.pruebabcp.data.service.ApiService
import com.example.pruebabcp.utils.Result
import javax.inject.Inject

class DeviceDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : DeviceDataSource {
    override suspend fun getDevices(): Result<List<DeviceDomainModel>> {
        return try {
            val response: List<ApiResponse> = apiService.getDevices()
            val devices: List<DeviceDomainModel> = response.map { it.toDomain() }
            Result.Success(devices)
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}

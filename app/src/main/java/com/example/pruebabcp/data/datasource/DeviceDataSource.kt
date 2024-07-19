package com.example.pruebabcp.data.datasource

import com.example.pruebabcp.domain.model.DeviceDomainModel
import com.example.pruebabcp.utils.Result

interface DeviceDataSource {
    suspend fun getDevices(): Result<List<DeviceDomainModel>>
}

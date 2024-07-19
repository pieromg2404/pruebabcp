package com.example.pruebabcp.domain.repository

import com.example.pruebabcp.domain.model.DeviceDomainModel
import com.example.pruebabcp.utils.Result

interface DeviceRepository {
    suspend fun getDevices(): Result<List<DeviceDomainModel>>
}

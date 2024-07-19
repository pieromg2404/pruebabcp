package com.example.pruebabcp.data.repository

import com.example.pruebabcp.domain.model.DeviceDomainModel

interface DeviceRepository {
    suspend fun getDevices(): Result<List<DeviceDomainModel>>
}

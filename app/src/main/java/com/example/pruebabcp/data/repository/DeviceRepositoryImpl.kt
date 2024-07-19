package com.example.pruebabcp.data.repository

import com.example.pruebabcp.domain.model.DeviceDomainModel
import com.example.pruebabcp.domain.repository.DeviceRepository
import com.example.pruebabcp.data.datasource.DeviceDataSource
import com.example.pruebabcp.utils.Result
import javax.inject.Inject

class DeviceRepositoryImpl @Inject constructor(
    private val deviceDataSource: DeviceDataSource
) : DeviceRepository {
    override suspend fun getDevices(): Result<List<DeviceDomainModel>> {
        return deviceDataSource.getDevices()
    }
}

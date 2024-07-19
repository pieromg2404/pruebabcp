package com.example.pruebabcp.domain.usecase

import com.example.pruebabcp.domain.model.DeviceDomainModel
import com.example.pruebabcp.domain.repository.DeviceRepository
import com.example.pruebabcp.utils.Result
import javax.inject.Inject

class GetDevicesUseCase @Inject constructor(private val repository: DeviceRepository) {
    suspend operator fun invoke(): Result<List<DeviceDomainModel>> {
        return repository.getDevices()
    }
}

package com.example.pruebabcp.data.model

import com.example.pruebabcp.domain.model.DeviceDomainModel

data class ApiResponse(
    val id: String,
    val name: String,
    val data: DeviceDataResponse?
)

data class DeviceDataResponse(
    val color: String?,
    val capacity: String?
)

fun ApiResponse.toDomain(): DeviceDomainModel {
    return DeviceDomainModel(
        id = id,
        name = name,
        data = data?.let {
            DeviceDomainModel.DeviceData(
                color = it.color,
                capacity = it.capacity
            )
        }
    )
}

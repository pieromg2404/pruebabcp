package com.example.pruebabcp.domain.model

data class DeviceDomainModel(
    val id: String,
    val name: String,
    val data: DeviceData?
) {
    data class DeviceData(
        val color: String?,
        val capacity: String?
    )
}

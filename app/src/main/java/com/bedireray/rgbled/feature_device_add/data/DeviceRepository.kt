package com.bedireray.rgbled.feature_device_add.data

import kotlinx.coroutines.flow.Flow

interface DeviceRepository {

    fun getDevices(): Flow<List<Device>>

    suspend fun insertDevice(device: Device)
}
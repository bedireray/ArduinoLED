package com.bedireray.rgbled.feature_device_add.use_case

import com.bedireray.rgbled.feature_device_add.data.Device
import com.bedireray.rgbled.feature_device_add.data.DeviceRepository
import kotlinx.coroutines.flow.Flow

class GetDevices(private val repository: DeviceRepository) {
    operator fun invoke(): Flow<List<Device>> {
        return repository.getDevices()
    }
}
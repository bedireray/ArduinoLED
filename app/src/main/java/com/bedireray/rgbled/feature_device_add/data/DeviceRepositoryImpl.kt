package com.bedireray.rgbled.feature_device_add.data

import kotlinx.coroutines.flow.Flow

class DeviceRepositoryImpl(private val dao: DeviceDao) : DeviceRepository {
    override fun getDevices(): Flow<List<Device>> {
        return dao.getDevices()
    }

    override suspend fun insertDevice(device: Device) {
        dao.insertDevice(device)
    }
}
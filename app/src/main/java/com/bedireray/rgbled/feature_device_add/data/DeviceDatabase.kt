package com.bedireray.rgbled.feature_device_add.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Device::class],
    version = 1
)
abstract class DeviceDatabase : RoomDatabase() {
    abstract val deviceDao: DeviceDao

    companion object {
        const val DATABASE_NAME = "device_db"
    }
}
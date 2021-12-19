package com.bedireray.rgbled.feature_device_add.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {

    @Query("SELECT * FROM device")
    fun getDevices(): Flow<List<Device>>

    @Insert(onConflict = REPLACE)
    suspend fun insertDevice(device: Device)
}
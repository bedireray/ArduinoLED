package com.bedireray.rgbled.feature_device_add.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Device(
    val name: String,
    @PrimaryKey val address: String,
)

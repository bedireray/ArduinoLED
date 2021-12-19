package com.bedireray.rgbled.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.bedireray.rgbled.core.util.BluetoothUtil
import com.bedireray.rgbled.feature_device_add.data.DeviceDatabase
import com.bedireray.rgbled.feature_device_add.data.DeviceRepository
import com.bedireray.rgbled.feature_device_add.data.DeviceRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDeviceDatabase(app: Application): DeviceDatabase {
        return Room.databaseBuilder(app, DeviceDatabase::class.java, DeviceDatabase.DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideDeviceRepository(db: DeviceDatabase): DeviceRepository {
        return DeviceRepositoryImpl(db.deviceDao)
    }

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideBluetoothUtil(@ApplicationContext context: Context): BluetoothUtil {
        return BluetoothUtil(context)
    }
}
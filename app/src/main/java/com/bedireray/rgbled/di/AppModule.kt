package com.bedireray.rgbled.di

import android.content.Context
import android.content.SharedPreferences
import com.bedireray.rgbled.core.util.BluetoothUtil
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
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideBluetoothUtil(@ApplicationContext context: Context): BluetoothUtil {
        return BluetoothUtil(context)
    }
}
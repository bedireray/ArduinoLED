package com.bedireray.rgbled.core.util

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context

class BluetoothUtil(context: Context) {
    private val bluetoothAdapter: BluetoothAdapter =
        (context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter

    fun getBondedDevices(): Set<BluetoothDevice> {
        return bluetoothAdapter.bondedDevices
    }

    fun enableBluetooth() {
        bluetoothAdapter.enable()
    }

    fun disableBluetooth() {
        bluetoothAdapter.disable()
    }
}
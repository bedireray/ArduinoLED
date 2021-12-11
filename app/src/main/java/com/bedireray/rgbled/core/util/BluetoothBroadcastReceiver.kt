package com.bedireray.rgbled.core.util

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BluetoothBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action.orEmpty()
        Log.i("BluetoothState", action)
        when (intent?.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1)) {
            BluetoothAdapter.STATE_TURNING_OFF -> {
                Log.i("BluetoothState", "STATE_TURNING_OFF")
            }
            BluetoothAdapter.STATE_OFF -> {
                Log.i("BluetoothState", "STATE_OFF")
            }
            BluetoothAdapter.STATE_TURNING_ON -> {
                Log.i("BluetoothState", "STATE_TURNING_ON")
            }
            BluetoothAdapter.STATE_ON -> {
                Log.i("BluetoothState", "STATE_ON")
            }
        }
    }
}
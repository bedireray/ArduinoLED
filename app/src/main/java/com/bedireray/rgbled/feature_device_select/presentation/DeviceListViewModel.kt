package com.bedireray.rgbled.feature_device_select.presentation

import android.bluetooth.BluetoothDevice
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bedireray.rgbled.core.util.BluetoothUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DeviceListViewModel @Inject constructor(
    private val bluetoothUtil: BluetoothUtil
) : ViewModel() {

    private val _deviceList: MutableLiveData<List<BluetoothDevice>> by lazy {
        MutableLiveData(bluetoothUtil.getBondedDevices().toList())
    }

    val deviceList: LiveData<List<BluetoothDevice>> = _deviceList
}
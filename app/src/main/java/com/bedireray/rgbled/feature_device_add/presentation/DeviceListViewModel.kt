package com.bedireray.rgbled.feature_device_add.presentation

import android.bluetooth.BluetoothDevice
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedireray.rgbled.core.util.BluetoothUtil
import com.bedireray.rgbled.feature_device_add.data.Device
import com.bedireray.rgbled.feature_device_add.data.DeviceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceListViewModel @Inject constructor(
    private val bluetoothUtil: BluetoothUtil,
    private val deviceRepository: DeviceRepository
) : ViewModel() {
    private val _deviceList: MutableLiveData<List<BluetoothDevice>> by lazy {
        MutableLiveData(bluetoothUtil.getBondedDevices().toList())
    }

    val deviceList: LiveData<List<BluetoothDevice>> = _deviceList

    fun pairDevice(bluetoothDevice: BluetoothDevice) {
        viewModelScope.launch {
            deviceRepository.insertDevice(Device(bluetoothDevice.name, bluetoothDevice.address))
        }
    }
}
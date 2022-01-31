package com.bedireray.rgbled.feature_device_add.presentation

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

    private val _deviceList: MutableLiveData<List<Device>> by lazy {
        MutableLiveData(bluetoothUtil.getBondedDevices().map { Device(it.name, it.address) }
            .toList())
    }

    val deviceList: LiveData<List<Device>> = _deviceList

    fun pairDevice(bluetoothDevice: Device) {
        viewModelScope.launch {
            deviceRepository.insertDevice(Device(bluetoothDevice.name, bluetoothDevice.address))
        }
    }

    fun connectDevice(bluetoothDevice: Device) {

    }
}
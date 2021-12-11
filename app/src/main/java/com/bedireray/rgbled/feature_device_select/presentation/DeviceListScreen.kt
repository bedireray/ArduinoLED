package com.bedireray.rgbled.feature_device_select.presentation

import android.bluetooth.BluetoothDevice
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DeviceListScreen(
    viewModel: DeviceListViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(viewModel.deviceList.value as List<BluetoothDevice>) { device ->
                Card {
                    Column(Modifier.padding(4.dp)) {
                        Text(text = device.name, fontSize = 18.sp)
                        Text(
                            text = device.address, fontSize = 12.sp,
                            style = TextStyle(
                                color = Color.Gray
                            )
                        )
                    }
                    Divider()
                }
            }
        }
    }
}
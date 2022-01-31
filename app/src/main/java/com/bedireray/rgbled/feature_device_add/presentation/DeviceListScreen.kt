package com.bedireray.rgbled.feature_device_add.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bedireray.rgbled.R
import com.bedireray.rgbled.feature_device_add.data.Device

@Composable
fun DeviceListScreen(
    navController: NavController,
    viewModel: DeviceListViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(viewModel.deviceList.value as List<Device>) { device ->
                DeviceCard(
                    device = device,
                    onClick = { navController.navigate("color_picker_screen/${device.address}") })
            }
        }
    }
}

@Composable
fun DeviceCard(
    isPaired: Boolean = false,
    device: Device,
    onClick: () -> Unit = {}
) {
    Card(Modifier.clickable { onClick() }) {
        Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
            Column {
                Text(text = device.name, fontSize = 18.sp)
                Text(
                    text = device.address, fontSize = 12.sp,
                    style = TextStyle(
                        color = Color.Gray
                    )
                )
            }
            if (isPaired)
                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_bluetooth_connected_24),
                        contentDescription = stringResource(R.string.paired_device)
                    )
                }
        }
        Divider()
    }
}
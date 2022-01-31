package com.bedireray.rgbled.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bedireray.rgbled.feature_control_device.presentation.ColorPickerScreen
import com.bedireray.rgbled.feature_device_add.presentation.DeviceListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        startDestination = "device_list_screen"
    ) {
        composable("device_list_screen") {
            DeviceListScreen(navController)
        }
        composable(
            "color_picker_screen/{macAddress}",
            arguments = listOf(
                navArgument("macAddress") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            ColorPickerScreen()
        }
    }
}

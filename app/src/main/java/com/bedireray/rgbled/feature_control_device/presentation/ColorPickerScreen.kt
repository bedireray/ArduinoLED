package com.bedireray.rgbled.feature_control_device.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bedireray.rgbled.R
import java.util.*


@Composable
@Preview
fun ColorPickerScreen() {
    var text by remember { mutableStateOf("") }
    var color by remember { mutableStateOf(Color.Black) }
    val regex = "[^a-fA-F0-9]".toRegex()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
                .background(color = color)
        )
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "#", fontSize = 32.sp, modifier = Modifier.padding(8.dp))
            TextField(
                value = text,
                onValueChange = {
                    if (it.length <= 6 && regex.containsMatchIn(it).not()) {
                        text = it.uppercase(Locale.ENGLISH)
                        if (it.length == 6)
                            color = Color(android.graphics.Color.parseColor("#$it"))
                    }
                },
                label = { Text("HEX") },
                singleLine = true
            )
        }
        Button(onClick = { /*TODO*/ }, Modifier.padding(top = 16.dp)) {
            Text(text = stringResource(R.string.send))
        }
    }
}
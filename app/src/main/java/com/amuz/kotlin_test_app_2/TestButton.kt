package com.amuz.kotlin_test_app_2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amuz.kotlin_test_app_2.network.WebOSManager

class TestButton {
    @Composable
    fun Render() {
        Column(
            modifier = Modifier
                .padding(16.dp),
        ) {
            Button(
                onClick = {
                    WebOSManager.connectMouse()
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "connectMouse")
            }
            Button(
                onClick = {
                    WebOSManager.showToast()
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "showToast")
            }
            Button(
                onClick = {
                    WebOSManager.launchYoutube()
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "launchYoutube")
            }
            Button(
                onClick = {
                    WebOSManager.sendText()
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "sendText")
            }
            Button(
                onClick = {
                    WebOSManager.sendEnter()
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "sendEnter")
            }
            Button(
                onClick = {
                    WebOSManager.sendDown()
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "sendDown")
            }
        }
    }
}
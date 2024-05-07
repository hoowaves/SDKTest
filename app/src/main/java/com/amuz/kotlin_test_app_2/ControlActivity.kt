package com.amuz.kotlin_test_app_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

class ControlActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Row {
                    val volumeUPButton = VolumeUPButton()
                    volumeUPButton.Render()
                    val volumeDownButton = VolumeDownButton()
                    volumeDownButton.Render()
                }
                Row {
                    val mouseButton = MouseButton()
                    mouseButton.Render()
                }
            }
        }
    }
}
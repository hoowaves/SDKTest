package com.amuz.kotlin_test_app_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.amuz.kotlin_test_app_2.network.DiscoveryListener
import com.amuz.kotlin_test_app_2.ui.theme.Kotlin_test_app_2Theme

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        val discovery = DiscoveryListener.initialize(this)

        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_test_app_2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Row {
                            val startScanButton = StartScanButton()
                            startScanButton.Render()
                        }
                        val scanList = ScanList()
                        scanList.Render()
                    }
                }
            }
        }
    }
}
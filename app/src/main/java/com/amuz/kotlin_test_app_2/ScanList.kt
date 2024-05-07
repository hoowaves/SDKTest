package com.amuz.kotlin_test_app_2

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.amuz.kotlin_test_app_2.network.DiscoveryListener
import com.amuz.kotlin_test_app_2.network.WebOSManager

class ScanList {
    @Composable
    fun Render(){
        val context = LocalContext.current
        val deviceList by DiscoveryListener.mDeviceList.observeAsState(emptyList())
        var showDialog by remember { mutableStateOf(false) }
        LazyColumn {
            items(deviceList) { device ->
                ClickableText(
                    text = AnnotatedString(device.friendlyName),
                    onClick = {
                        WebOSManager.initialize(device)
                        showDialog = true
                    },
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        // 모달 창 표시
        if (showDialog) {
            AuthDialog(
                onDismissRequest = { showDialog = false },
                onConfirmClick = { pinCode ->
                    WebOSManager.sendPairingKey(pinCode)
                    showDialog = false
                    val intent = Intent(context, ControlActivity::class.java)
                    context.startActivity(intent)
                }
            )
        }
    }
}
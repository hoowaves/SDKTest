package com.amuz.kotlin_test_app_2.network

import android.util.Log
import com.connectsdk.device.ConnectableDevice
import com.connectsdk.service.DeviceService.PairingType
import com.connectsdk.service.WebOSTVService
import com.connectsdk.service.capability.KeyControl
import com.connectsdk.service.capability.Launcher
import com.connectsdk.service.capability.MouseControl

object WebOSManager {
    private var mDevice: ConnectableDevice? = null
    private var webOSTVService: WebOSTVService? = null
    private var keyControl: KeyControl? = null
    private var mouseControl: MouseControl? = null

    fun initialize(device: ConnectableDevice?) {
        mDevice = device
        webOSTVService = device!!.getServiceByName("webOS TV") as WebOSTVService
//        Log.d("permissions", webOSTVService!!.permissions.toString())
//        webOSTVService = device!!.getServiceByName("webOS") as WebOSTVService
        device.setPairingType(PairingType.PIN_CODE)
        device.connect()
        DiscoveryListener.stopScan()
    }

    fun sendPairingKey(pinCode: String) {
        mDevice?.sendPairingKey(pinCode)
    }

    fun volumeUP() {
        webOSTVService!!.volumeControl.volumeUp(null)
    }

    fun volumeDown() {
        webOSTVService!!.volumeControl.volumeDown(null)
    }

    fun connectMouse() {
        webOSTVService!!.connectMouse()
        webOSTVService!!.click()
//        mouseControl = mDevice?.getCapability(MouseControl::class.java)
//        mouseControl = webOSTVService!!.mouseControl;
//        keyControl = mDevice?.getCapability(KeyControl::class.java)
//        mouseControl!!.click();

        //mDevice?.keyControl?.sendKeyCode(KeyControl.KeyCode.NUM_0, null)
        //keyControl?.sendKeyCode(KeyControl.KeyCode.NUM_0, null)
        //mDevice?.getCapability(KeyControl::class.java)?.sendKeyCode(KeyControl.KeyCode.NUM_0, null)
        //mDevice?.keyControl?.sendKeyCode(KeyControl.KeyCode.NUM_0, null)
    }

    fun showToast() {
        webOSTVService?.showToast("Test~~", null)
    }

    fun launchYoutube() {
        webOSTVService?.launchApp(Launcher.YouTube, null)
    }

    fun sendText() {
        webOSTVService?.sendText("Test~~")
    }

    fun sendEnter() {
        webOSTVService?.sendEnter()
    }

    fun sendDown(){
        webOSTVService?.down(null)
    }

}
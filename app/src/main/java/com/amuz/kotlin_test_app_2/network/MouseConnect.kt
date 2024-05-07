package com.amuz.kotlin_test_app_2.network

import android.util.Log
import com.connectsdk.core.Util
import com.connectsdk.service.capability.listeners.ResponseListener
import com.connectsdk.service.command.ServiceCommand
import com.connectsdk.service.command.ServiceCommandError
import com.connectsdk.service.command.ServiceSubscription
import com.connectsdk.service.command.URLServiceSubscription
import com.connectsdk.service.webos.WebOSTVMouseSocketConnection
import com.connectsdk.service.webos.WebOSTVMouseSocketConnection.WebOSTVMouseSocketListener
import org.json.JSONException
import org.json.JSONObject

class MouseConnect : ServiceCommand.ServiceCommandProcessor {

    var mouseSocket: WebOSTVMouseSocketConnection? = null

    private fun testConnectMouse(successHandler: WebOSTVMouseSocketListener) {
        Log.d("mouseSocket",mouseSocket.toString())
        if (mouseSocket != null) return
        val uri = "ssap://com.webos.service.networkinput/getPointerInputSocket"
        Log.d("uri",uri)
        val listener: ResponseListener<Any> = object : ResponseListener<Any> {
            override fun onSuccess(response: Any) {
                try {
                    val jsonObj = response as JSONObject
                    val socketPath = jsonObj["socketPath"] as String
                    mouseSocket = WebOSTVMouseSocketConnection(socketPath, successHandler)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }

            override fun onError(error: ServiceCommandError) {
                Log.w(Util.T, "Connect mouse error: " + error.message)
            }
        }
        val request = ServiceCommand<ResponseListener<Any>>(this, uri, null, true, listener)
        request.send()
    }

    fun click(){
        testConnectMouse(object : WebOSTVMouseSocketConnection.WebOSTVMouseSocketListener {
            override fun onConnected() {
                Log.d("onConnected","click")
                mouseSocket?.click()
            }
        })
    }

    override fun unsubscribe(subscription: URLServiceSubscription<*>?) {
        Log.d("unsubscribe",subscription.toString())
    }

    override fun unsubscribe(subscription: ServiceSubscription<*>?) {
        Log.d("unsubscribe",subscription.toString())
    }

    override fun sendCommand(command: ServiceCommand<*>?) {
        Log.d("sendCommand",command.toString())
    }
}
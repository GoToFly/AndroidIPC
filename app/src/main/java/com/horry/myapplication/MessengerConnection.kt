package com.horry.myapplication

import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.IBinder
import android.os.Messenger
import android.util.Log
import android.widget.Button
import android.widget.Toast

/**
 * 通过handler机制想Service发送消息
 */
class MessengerConnection(internal var context: Context) : ServiceConnection {
    var button: Button? = null;
    var messenger: Messenger? = null;
    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        messenger = Messenger(service);
        Log.d("BindService", "onServiceConnected")
        button!!.text = "绑定成功";
    }

    override fun onServiceDisconnected(name: ComponentName) {
        Toast.makeText(context, "断开链接", Toast.LENGTH_SHORT).show()
    }
}

package com.horry.myapplication.binder

import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.horry.myapplication.MyBinder

/**
 * Connection是Binder中Android进程间通信的桥梁，将IBinder对象在进程间传输
 */
class BindConnection(internal var context: Context) : ServiceConnection {
    var binder: MyBinder? = null;
    var button: Button? = null;

    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        this.binder = service as MyBinder
        Log.d("BindService", "onServiceConnected")
        button!!.text="绑定成功";
    }

    override fun onServiceDisconnected(name: ComponentName) {
        Toast.makeText(context, "断开链接", Toast.LENGTH_SHORT).show()
    }
}

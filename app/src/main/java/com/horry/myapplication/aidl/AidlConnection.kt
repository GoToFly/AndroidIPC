package com.horry.myapplication.aidl

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
class AidlConnection(internal var context: Context) : ServiceConnection {
    var button: Button? = null;
    var stub: IBookAidlInterface? = null;
    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        this.stub = IBookAidlInterface.Stub.asInterface(service);

        Log.d("BindService", "onServiceConnected")
        button!!.text = "绑定成功";
    }

    override fun onServiceDisconnected(name: ComponentName) {
        Log.d("BindService", "onServiceDisconnected")
        this.stub = null;
    }
}

package com.horry.myapplication.binder

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.horry.myapplication.MyBinder

class BindService : Service() {
    var binder: MyBinder? = null;

    override fun onCreate() {
        super.onCreate()
        binder = MyBinder();
        binder!!.bindService = this;
    }

    fun startDownload() {
        Log.d("BindService", "startDownload");
    }

    fun stopDownload() {
        Log.d("BindService", "stopDownload");
    }

    override fun onBind(intent: Intent): IBinder {
        //TODO("Return the communication channel to the service.")
        return binder!!
    }
}

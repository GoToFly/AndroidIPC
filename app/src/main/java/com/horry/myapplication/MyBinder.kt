package com.horry.myapplication

import android.os.Binder

/**
 * 继承自Binder
 */
class MyBinder : Binder() {

    var bindService: BindService? = null;

    fun start() {
        bindService!!.startDownload()
    }

    fun stop() {
        bindService!!.stopDownload();
    }
}

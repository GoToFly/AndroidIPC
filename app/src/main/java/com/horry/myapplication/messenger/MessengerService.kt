package com.horry.myapplication.messenger

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log

class MessengerService : Service() {
    var handler = Handler(object : Handler.Callback {
        override fun handleMessage(msg: Message?): Boolean {
            when (msg!!.what) {
                1 -> {
                    Log.d("MessengerService", "startDownload");
                }
                2 -> {
                    Log.d("MessengerService", "stopDownload");
                }
                3, 4 -> {//同时符合3，4
                }
                else -> {
                }
            }
            return true;
        }
    });

    var messenger: Messenger = Messenger(handler);

    var activityMessenger: Messenger? = null;

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {
        activityMessenger = intent.getParcelableExtra("Messenger");
        var message: Message = Message.obtain();
        message.what = 1;
        activityMessenger!!.send(message);
        return messenger.binder
    }
}

package com.horry.myapplication.messenger

import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.Messenger
import android.util.Log
import android.view.View
import android.widget.Button
import com.horry.myapplication.R

/**
 *
 * @param messenger Activity中的Messenger，将此Messenger传递到Service中，
 * 从而使Service可以通过Messenger向Activity发送消息
 * @param connection 链接的桥梁
 */
class MessengerActivity : AppCompatActivity() {

    var connection: MessengerConnection? = null;

    var handler = Handler(object : Handler.Callback {
        override fun handleMessage(msg: Message?): Boolean {
            when (msg!!.what) {
                1 -> {
                    Log.d("MessengerActivity", "Receive Msg");
                }
                else -> {
                }
            }
            return true;
        }
    });

    var messenger: Messenger = Messenger(handler);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        findViewById<View>(R.id.btn).setOnClickListener {
            bindMessengerService();
        }
        findViewById<View>(R.id.btn2).setOnClickListener {
            var message: Message = Message.obtain();
            message.what = 1;
            connection!!.messenger!!.send(message);
        }
    }

    fun bindMessengerService() {
        connection = MessengerConnection(this);
        connection!!.button = findViewById<View>(R.id.btn) as Button;
        var intent = Intent(this, MessengerService::class.java);
        intent.putExtra("Messenger", messenger);

        bindService(
            intent,
            connection as ServiceConnection,
            Context.BIND_AUTO_CREATE
        );
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection as ServiceConnection);
    }
}

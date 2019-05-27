package com.horry.myapplication.binder

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.horry.myapplication.R

class IBinderActivity : AppCompatActivity() {
    var connection: BindConnection? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        findViewById<View>(R.id.btn).setOnClickListener {
            bindIBinderService();
        }
        findViewById<View>(R.id.btn2).setOnClickListener {
            connection!!.binder!!.start();
            connection!!.binder!!.stop();
        }
    }

    fun bindIBinderService() {
        connection = BindConnection(this);
        connection!!.button = findViewById<View>(R.id.btn) as Button;
        bindService(Intent(this, BindService::class.java), connection, Context.BIND_AUTO_CREATE);
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection);
    }
}

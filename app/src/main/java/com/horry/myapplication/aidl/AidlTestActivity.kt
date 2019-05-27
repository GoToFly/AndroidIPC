package com.horry.myapplication.aidl

import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Button
import com.horry.myapplication.R
import com.horry.myapplication.messenger.MessengerService

/**
 *
 * @param messenger Activity中的Messenger，将此Messenger传递到Service中，
 * 从而使Service可以通过Messenger向Activity发送消息
 * @param connection 链接的桥梁
 */
class AidlTestActivity : AppCompatActivity() {

    var connection: AidlConnection? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        findViewById<View>(R.id.btn).setOnClickListener {
            bindMessengerService();
        }
        findViewById<View>(R.id.btn2).setOnClickListener {
            var book = Book("Love", 20) as Book;
            connection!!.stub!!.addBook(book);
            //客户端主动去拉数据
            book = connection!!.stub!!.book;
            Log.d("AidlService", "获得一本书:" + book.name);

        }
    }

    fun bindMessengerService() {
        connection = AidlConnection(this);
        connection!!.button = findViewById<View>(R.id.btn) as Button;
        var intent = Intent(this, AidlService::class.java);
        bindService(
            intent,
            connection as AidlConnection,
            Context.BIND_AUTO_CREATE
        );
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection as AidlConnection);
    }
}

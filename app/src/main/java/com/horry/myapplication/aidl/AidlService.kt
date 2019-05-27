package com.horry.myapplication.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class AidlService : Service() {

    private var stub: IBookAidlInterface.Stub? = null
    override fun onCreate() {
        super.onCreate()
        stub = object : IBookAidlInterface.Stub() {
            override fun addBook(book: Book?) {
                Log.d("AidlService", "添加一本书:" + book!!.name);
            }

            override fun getBook(): Book {
                var book = Book("Hate", 10);
                Log.d("AidlService", "返回一本书:" + book!!.name);
                return book;
            }

        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return stub
    }

}

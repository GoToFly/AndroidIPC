package com.horry.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Intent.FLAG_ACTIVITY_CLEAR_TASK;
        setContentView(R.layout.activity_main2)
        findViewById<Button>(R.id.btn).setOnClickListener {
            val intent1 = Intent(this, Main3Activity::class.java)
            startActivity(intent1)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart-2");
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart-2");
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume-2");
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause-2");
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop-2");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy-2");
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "onSaveInstanceState-2");
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("MainActivity", "onSaveInstanceState PersistableBundle-2");
    }
}

package com.horry.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    var alphaAnimation: Animation? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.trans) as Animation?;
        alphaAnimation!!.duration = 1000;
        alphaAnimation!!.fillAfter = true;
        alphaAnimation!!.repeatMode=Animation.INFINITE;
        findViewById<Button>(R.id.btn).setOnClickListener {
                        val intent1 = Intent(this, Main2Activity::class.java)
            startActivity(intent1)
//            btn.startAnimation(alphaAnimation);
        }
        Log.d("MainActivity", "onCreate");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart");
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause");
    }
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy");
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MainActivity", "onRestoreInstanceState");
    }
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "onSaveInstanceState");
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("MainActivity", "onSaveInstanceState PersistableBundle");
    }
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Log.d("MainActivity", "onConfigurationChanged" + newConfig.toString());

    }
}

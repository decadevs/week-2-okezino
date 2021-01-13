package com.example.jos_week2_task

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Handler;
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    val Tag : String = "MainActivityLog"
    private val handler = Handler()
    private var displayScreenOrientation = ""

        var screenCount = -1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(Tag,"onCreated")
        if(savedInstanceState != null){
            screenCount = savedInstanceState.getInt("Round")
        }
        screenCount++
       handler.postDelayed({textViewDisplayStateChange.text = getString(R.string.onCreate)},500)
        displayScreenOrientation = if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) "LANDSCAPE" else "PORTRAIT"

        textViewDisplayStateChange.text = getString(R.string.onCreate)
        lifeCycleView.text = displayScreenOrientation + " " + screenCount.toString()






    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Round", screenCount)
    }



    override fun onStart() {
        super.onStart()
        handler.postDelayed({textViewDisplayStateChange.text = getString(R.string.onStart)},2000)


    }
    override fun onResume() {
        Log.d(Tag,"onResume")
        super.onResume()
        handler.postDelayed({textViewDisplayStateChange.text = getString(R.string.onResume)},3000)

    }

    fun nextActivity(view: View) {
        val intent = Intent(this, FragmentActivity::class.java)
        startActivity(intent)

    }

    override fun onPause() {
        Log.d(Tag,"onPaused")
        super.onPause()
        textViewDisplayStateChange.text = getString(R.string.onPause)


    }
    override fun onRestart() {
        Log.d(Tag,"onRestart")
        super.onRestart()
        textViewDisplayStateChange.text = getString(R.string.onRestart)
        handler.postDelayed({textViewDisplayStateChange.text = getString(R.string.onResume)},1000)

    }
    override fun onStop() {
        Log.d(Tag,"onStop State")
        super.onStop()
        textViewDisplayStateChange.text = getString(R.string.onStop)
        handler.postDelayed({textViewDisplayStateChange.text = getString(R.string.onStop)},2000)

    }

    override fun onDestroy() {
        Log.d(Tag,"onDestroy")
        Toast.makeText(this@MainActivity,"on Destroy", Toast.LENGTH_LONG).show()
        super.onDestroy()
        textViewDisplayStateChange.text = getString(R.string.onDestroy)
    }

}
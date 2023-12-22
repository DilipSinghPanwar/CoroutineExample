package com.example.coroutineexample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnClick).setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                printFbFollower()
            }
        }
    }

    private suspend fun printFbFollower(){
        var fbFollowerCount = 0
        val job = CoroutineScope(Dispatchers.Main).launch {
            fbFollowerCount = getFbFollower()
        }
        job.join()
        Log.w("TAG", "printFbFollower : $fbFollowerCount")
    }

    private suspend fun getFbFollower(): Int {
        delay(1000)
        return 25
    }
}
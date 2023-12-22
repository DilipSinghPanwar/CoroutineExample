package com.example.coroutineexample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity5 : AppCompatActivity() {
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
        var instagramFollowerCount = 0
        val deferred = CoroutineScope(Dispatchers.Main).async {
            fbFollowerCount = getFbFollower()
        }
        val deferred2 = CoroutineScope(Dispatchers.Main).async {
            instagramFollowerCount = getInstagramFollower()
        }
        deferred.await()
        deferred2.await()
        Log.w("TAG", "print Fb Follower : $fbFollowerCount")
        Log.w("TAG", "print Instagram Follower : $instagramFollowerCount")
    }

    private suspend fun getFbFollower(): Int {
        delay(1000)
        return 25
    }
    private suspend fun getInstagramFollower(): Int {
        delay(1000)
        return 50
    }
}
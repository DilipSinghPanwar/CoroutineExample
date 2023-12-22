package com.example.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.*

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnClick).setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                task1()
            }
            CoroutineScope(Dispatchers.Main).launch {
                task2()
            }
        }
    }

    private suspend fun task1(){
        Log.w("TAG", "start task 1")
//        yield()
        delay(1000)
        Log.w("TAG", "end task 1")
    }

    private suspend fun task2(){
        Log.w("TAG", "start task 2")
        yield()
        Log.w("TAG", "end task 2")
    }
}
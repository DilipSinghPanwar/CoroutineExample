package com.example.coroutineexample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnClick).setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
//                executeTask()
//                executeTask1()
                executeTask2()
            }
        }
    }

    //blocking
    private suspend fun executeTask2() {
        println("start")
        runBlocking {
            launch {
                delay(1000)
                println("inside")
            }
        }
        println("end")
    }
    //blocking
    private suspend fun executeTask1() {
        println("start")
        withContext(Dispatchers.Main){
            delay(1000)
            println("inside")
        }
        println("end")
    }
    //non blocking
    private suspend fun executeTask() {
        println("start")
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            println("inside")
        }
        println("end")
    }

}
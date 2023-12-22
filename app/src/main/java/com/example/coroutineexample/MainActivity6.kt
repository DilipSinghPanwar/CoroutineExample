package com.example.coroutineexample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity6 : AppCompatActivity() {

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnClick).setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                printNumber()
            }
        }
    }

    //not working
    private suspend fun printNumber() {
        job = CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..1000) {
                if (isActive) {
                    println("value of i: $i")
                }
            }
        }
        delay(500)
        job.cancel()
        job.join()
    }

}
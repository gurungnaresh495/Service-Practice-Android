package com.example.servicepractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init()
    {

        button_start.setOnClickListener {

            var intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        button_stop.setOnClickListener {

            var intent = Intent(this, MyService::class.java)
            stopService(intent)
        }

        button_send_data.setOnClickListener {
            var intent = Intent(this, MyService2::class.java)
            intent.putExtra("data", edit_text_get_data.text.toString())
            startService(intent)
        }
    }
}
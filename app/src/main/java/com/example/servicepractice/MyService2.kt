package com.example.servicepractice

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.widget.Toast

class MyService2 : IntentService("serviceThread") {

    override fun onHandleIntent(intent: Intent?) {
        var handler = Handler()
        handler.post{
            if (intent != null) {
                Toast.makeText(this, intent.getStringExtra("data"), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
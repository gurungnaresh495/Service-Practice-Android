package com.example.servicepractice

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init()
    {
        var handler = Handler()
        var thread = Thread()
        {
            var mp =MediaPlayer.create(this, R.raw.bensound_dubstep)
            kotlin.run{
                mp.start()
                for (i in 5 downTo 1 )
                {
                    handler.post{
                        text_view_music_name.setText("Starting your application in $i seconds")
                    }
                    Thread.sleep(1000)
                }
                mp.stop()
            }
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }.start()
    }
}
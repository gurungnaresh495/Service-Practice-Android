package com.example.servicepractice

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.View
import kotlinx.android.synthetic.main.activity_async.*
import java.io.BufferedInputStream
import java.net.URL

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
        progressBar.visibility = View.GONE
        button_get_started.setOnClickListener {
            var myTask = MyTask()
            myTask.execute()
        }

    }

    inner class MyTask: AsyncTask<String, Int, Bitmap>(){
        override fun doInBackground(vararg params: String?): Bitmap {
            var url = URL("https://wallpaperaccess.com/download/anime-desktop-58402")
            var connection = url.openConnection()
            var inputStream = connection.getInputStream()
            var bufferedInputStream = BufferedInputStream(inputStream)
            return BitmapFactory.decodeStream(bufferedInputStream)
        }

        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            progressBar.visibility = View.GONE
            image_view.setImageBitmap(result)
        }

    }
}
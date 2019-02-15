package com.example.jlavera.githug.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log


class DownloadImageTask(
        private val callback: (Bitmap) -> Unit
) : AsyncTask<String, Void, Bitmap>() {

    override fun doInBackground(vararg urls: String): Bitmap? {
        val urldisplay = urls[0]
        var bmp: Bitmap? = null
        try {
            val stream = java.net.URL(urldisplay).openStream()
            bmp = BitmapFactory.decodeStream(stream)
        } catch (e: Exception) {
            Log.e("Error", e.message)
            e.printStackTrace()
        }

        return bmp
    }

    override fun onPostExecute(result: Bitmap) {
        callback(result)
    }
}
package com.example.jlavera.githug.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.jlavera.githug.R
import com.example.jlavera.githug.utils.DownloadImageTask
import com.example.jlavera.githug.utils.GithubConnector

class Profile : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val profile = GithubConnector.instance.getProfile()

        val view = inflater.inflate(R.layout.profile_fragment, container, false)

        view.findViewById<TextView>(R.id.profile_username).text = profile.username
        view.findViewById<TextView>(R.id.profile_fullname).text = profile.fullName

        view.findViewById<ImageView>(R.id.profile_image).setImageResource(R.drawable.default_profile_image)
        DownloadImageTask {
            bm: Bitmap -> view.findViewById<ImageView>(R.id.profile_image).setImageBitmap(bm)
        }.execute(profile.imageLink)

        return view
    }
}
package com.example.jlavera.githug.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jlavera.githug.R
import com.example.jlavera.githug.utils.GithubConnector

class Repositories : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val repositories = GithubConnector.instance.getRepositories()

        val view = inflater.inflate(R.layout.repositories_fragment, container, false)

        viewManager = LinearLayoutManager(view.context)


        return view
    }
}

package com.example.jlavera.githug.utils

import com.example.jlavera.githug.domain.Profile
import com.example.jlavera.githug.domain.Repository

class GithubConnector private constructor(val token: String) {
    companion object {
        val instance by lazy {
            GithubConnector("asd")
        }
    }

    fun getProfile(): Profile {
        return Profile("jlavera", "Joaquin Lavera", "https://avatars3.githubusercontent.com/u/2030265?v=4")
    }

    fun getRepositories(): List<Repository> {
        return listOf(
                Repository("Repo 1", "Scala", 150),
                Repository("Repo 2", "Node.JS", 350),
                Repository("Repo tres", "Pascal", 200)
                )
    }
}

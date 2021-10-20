package com.example.githubokhttpissueslist.data.repos

import com.example.githubokhttpissueslist.data.api.Client

object GithubRepository {

    suspend fun getIssues() = Client.api.getIssues()
}
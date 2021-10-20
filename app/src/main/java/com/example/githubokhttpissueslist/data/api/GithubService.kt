package com.example.githubokhttpissueslist.data.api

import com.example.githubokhttpissueslist.data.models.Issues
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {
    @GET("issues")
    suspend fun getIssues(): Response<List<Issues>>


}

package com.lubnamariyam.retrofitmvvmgithubapi.network

import com.lubnamariyam.retrofitmvvmgithubapi.model.response.GithubResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    // https://api.github.com/repos/octocat/hello-world/issues

    @GET("/repos/octocat/hello-world/issues")
    fun getData(): Call<List<GithubResponse>>
}
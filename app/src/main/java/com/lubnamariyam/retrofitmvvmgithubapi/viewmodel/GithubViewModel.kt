package com.lubnamariyam.retrofitmvvmgithubapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lubnamariyam.retrofitmvvmgithubapi.model.response.GithubResponse
import com.lubnamariyam.retrofitmvvmgithubapi.network.RetrofitInstance
import com.lubnamariyam.retrofitmvvmgithubapi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubViewModel: ViewModel() {
    // Live Data
    var githubDataList = MutableLiveData<List<GithubResponse>>()

    fun getApiData(){
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitService.getData().enqueue(object : Callback<List<GithubResponse>>{
            override fun onResponse(
                call: Call<List<GithubResponse>>,
                response: Response<List<GithubResponse>>
            ) {
                // Success
                githubDataList.value = response.body()
            }

            override fun onFailure(call: Call<List<GithubResponse>>, t: Throwable) {
                // Failure
            }

        })
    }
}
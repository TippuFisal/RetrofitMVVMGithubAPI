package com.lubnamariyam.retrofitmvvmgithubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lubnamariyam.retrofitmvvmgithubapi.adapter.GithubAdapter
import com.lubnamariyam.retrofitmvvmgithubapi.model.response.GithubResponse
import com.lubnamariyam.retrofitmvvmgithubapi.viewmodel.GithubViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var githubViewModel: GithubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initGithubAPI()
    }

    fun initGithubAPI(){
        githubViewModel = ViewModelProvider(this).get(GithubViewModel::class.java)

        // Call github API from viewmodel
        githubViewModel.getApiData()

        // Livedata observer
        githubViewModel.githubDataList.observe(this, Observer {
            initAdapter(it)
        })

    }

    private fun initAdapter(data: List<GithubResponse>){
        rvGithubList.layoutManager = LinearLayoutManager(this)
        val adapter = GithubAdapter(data)
        rvGithubList.adapter = adapter
    }
}
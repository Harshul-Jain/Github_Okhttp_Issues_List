package com.example.githubokhttpissueslist.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.githubokhttpissueslist.R
import com.example.githubokhttpissueslist.data.repos.GithubRepository
import com.example.githubokhttpissueslist.ui.viewModel.GithubViewModel

class MainActivity : AppCompatActivity() {

    val vm by lazy {
        ViewModelProvider(this).get(GithubViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm.fetchIssues()
        vm.issues.observe(this, Observer {

        })
    }
}
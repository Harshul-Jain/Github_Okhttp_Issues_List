package com.example.githubokhttpissueslist.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubokhttpissueslist.R
import com.example.githubokhttpissueslist.data.models.Issues
import com.example.githubokhttpissueslist.data.repos.GithubRepository
import com.example.githubokhttpissueslist.ui.adapter.IssueAdapter
import com.example.githubokhttpissueslist.ui.viewModel.GithubViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val vm by lazy {
        ViewModelProvider(this).get(GithubViewModel::class.java)
    }

    private val list = arrayListOf<Issues>()

    val adapter = IssueAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        issuesRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        vm.fetchIssues()
        vm.issues.observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                list.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }
}
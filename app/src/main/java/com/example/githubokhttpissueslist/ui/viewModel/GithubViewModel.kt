package com.example.githubokhttpissueslist.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubokhttpissueslist.data.models.Issues
import com.example.githubokhttpissueslist.data.repos.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GithubViewModel : ViewModel() {

    val issues = MutableLiveData<List<Issues>>()
    fun fetchIssues() {
        runIO {
            val response = withContext(Dispatchers.IO) { GithubRepository.getIssues() }
            if (response.isSuccessful) {
                response.body()?.let {
                    issues.postValue(it)
                }
            }
        }
    }
}

/** Extension function for [ViewModel] scope*/
fun ViewModel.runIO(function: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(Dispatchers.IO) {
        function()
    }
}

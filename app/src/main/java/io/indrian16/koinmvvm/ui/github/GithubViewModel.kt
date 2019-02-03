package io.indrian16.koinmvvm.ui.github

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.indrian16.koinmvvm.data.repository.Repository

class GithubViewModel(private val repository: Repository) : ViewModel() {

    val stateLiveData = MutableLiveData<GithubState>()

    fun sayHello() {

        stateLiveData.value = Loading
        repository.getHello(object : Repository.RepoCallback {

            override fun helloKoin(message: String) {

                stateLiveData.value = DataRepo(message)
            }
        })
    }
}
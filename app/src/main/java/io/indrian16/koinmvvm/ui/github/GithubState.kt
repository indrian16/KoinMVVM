package io.indrian16.koinmvvm.ui.github

sealed class GithubState

data class DataRepo(val message: String) : GithubState()
object Loading : GithubState()
object Error : GithubState()
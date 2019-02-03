package io.indrian16.koinmvvm.di

import io.indrian16.koinmvvm.data.repository.Repository
import io.indrian16.koinmvvm.ui.github.GithubViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val repoModule = module {

    single { Repository() }
}

val appModule = module {

    viewModel { GithubViewModel(get()) }
}
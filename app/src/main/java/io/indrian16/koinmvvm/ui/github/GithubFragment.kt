package io.indrian16.koinmvvm.ui.github

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.indrian16.koinmvvm.R
import io.indrian16.koinmvvm.util.showToast
import io.indrian16.koinmvvm.util.toGone
import io.indrian16.koinmvvm.util.toVisible
import kotlinx.android.synthetic.main.fragment_github.*
import org.koin.android.viewmodel.ext.android.viewModel

class GithubFragment : Fragment() {

    private val viewModel: GithubViewModel by viewModel()

    private val stateObserver = Observer<GithubState> { state ->

        when (state) {

            is DataRepo -> {

                progressBar.toGone()
                showToast(state.message)
            }

            is Loading -> {

                progressBar.toVisible()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_github, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getObserver()
        initListener()
    }

    private fun getObserver() {

        viewModel.stateLiveData.observe(this, stateObserver)
    }

    private fun initListener() {

        btnSayHello.setOnClickListener { viewModel.sayHello() }
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.stateLiveData.removeObserver(stateObserver)
    }

    companion object {

        fun newInstance() = GithubFragment()
    }
}

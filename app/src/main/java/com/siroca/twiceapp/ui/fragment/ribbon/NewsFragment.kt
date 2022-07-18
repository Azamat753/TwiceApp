package com.siroca.twiceapp.ui.fragment.ribbon

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.core.base.BaseFragment
import com.example.core.base.BaseResult
import com.example.domain.news.entity.NewsEntity
import com.siroca.twiceapp.databinding.FragmentNewsBinding
import com.siroca.twiceapp.ui.fragment.ribbon.adapter.NewsAdapter
import com.siroca.twiceapp.utils.ext.onTryAgainListener
import com.siroca.twiceapp.utils.ext.renderSimpleResult
import com.siroca.twiceapp.utils.ext.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>(FragmentNewsBinding::inflate) {

    private val adapter: NewsAdapter by lazy {
        NewsAdapter()
    }
    private val viewModel by viewModels<NewsViewModel>()

    override fun setupUI() {
        initAdapter()
        initBtn()
    }

    private fun initBtn() {
        onTryAgainListener(requireView()) {
            viewModel.tryAgain()
        }
    }

    override fun setupObservers() {
        super.setupObservers()
        observeNews()
    }

    private fun observeNews() {
        viewModel.newsResult.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { handleResult(it) }.launchIn(lifecycleScope)
    }

    private fun handleResult(result: BaseResult<List<NewsEntity>, String>) {
        renderSimpleResult(requireBinding().root,
            result,
            onSuccess = { data ->
                handleRibbon(data)
            },
            onError = { msg ->
                handleError(msg)
            })
    }

    private fun handleError(msg: String?) {
        requireContext().showToast(msg)
    }

    private fun handleRibbon(data: List<NewsEntity>) {
        adapter.list = data
    }

    private fun initAdapter() {
        requireBinding().rvRb.adapter = adapter
    }

}
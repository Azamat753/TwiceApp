package com.siroca.twiceapp.ui.fragment.details

import   androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.core.base.BaseResult
import com.example.core.base.takeSuccess
import com.example.domain.detail.entity.DetailEntity
import com.siroca.twiceapp.databinding.FragmentDetailsBinding
import com.siroca.twiceapp.ui.fragment.participants.adapter.ParticipantsAdapter
import com.siroca.twiceapp.utils.ext.onTryAgainListener
import com.siroca.twiceapp.utils.ext.renderSimpleResult
import com.siroca.twiceapp.utils.ext.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(
    FragmentDetailsBinding::inflate
), ParticipantsAdapter.Result {

    private val adapter: ParticipantsAdapter by lazy {
        ParticipantsAdapter(this, true)
    }
    private val arguments: DetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<DetailsViewModel>()

    override fun setupUI() {
        initData(arguments.id)
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
        observeDetail()
    }

    private fun observeDetail() {
        viewModel.detailResult.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { handleResult(it) }.launchIn(lifecycleScope)
    }

    private fun handleResult(result: BaseResult<List<DetailEntity>, String>) {
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

    private fun handleRibbon(data: List<DetailEntity>) {

    }

    /**
     * Запрос через ViewModel , viewModel в свою очередь дергает domain слой ,
    domain дергает data слой, и только через data слой осуществляется запрос на сервер
     */
    private fun initData(id: String) {

    }

    override fun onClickListener(id: String) {

    }

    private fun initAdapter() {
        requireBinding().rvDetails.adapter = adapter
    }

}
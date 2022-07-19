package com.siroca.twiceapp.ui.fragment.participants

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.core.base.BaseResult
import com.example.domain.participants.entity.ParticipantEntity
import com.siroca.twiceapp.databinding.FragmentParticipantsBinding
import com.siroca.twiceapp.ui.fragment.participants.adapter.ParticipantsAdapter
import com.siroca.twiceapp.utils.ext.onTryAgainListener
import com.siroca.twiceapp.utils.ext.renderSimpleResult
import com.siroca.twiceapp.utils.ext.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ParticipantsFragment :
    BaseFragment<FragmentParticipantsBinding>(FragmentParticipantsBinding::inflate),
    ParticipantsAdapter.Result {

    private val adapter: ParticipantsAdapter by lazy {
        ParticipantsAdapter(this, true)
    }
    private val viewModel by viewModels<ParticipantsViewModel>()

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
        observeParticipants()
    }

    private fun observeParticipants() {
        viewModel.participantsResult.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { handleParticipants(it) }.launchIn(lifecycleScope)
    }

    private fun handleParticipants(result: BaseResult<List<ParticipantEntity>, String>) {
        renderSimpleResult(requireBinding().root,
            result,
            onSuccess = { data ->
                handleParticipants(data)
            },
            onError = { msg ->
                handleError(msg)
            })
    }

    private fun handleError(msg: String?) {
        requireContext().showToast(msg)
    }

    private fun handleParticipants(data: List<ParticipantEntity>) {
        adapter.list = data
    }

    private fun initAdapter() {
        requireBinding().rvParticipants.adapter = adapter
    }

    /**
    Переход с фрагмента Участницы на фрагмент Подробности
     */
    override fun onClickListener(id: String) {
        navigateDetails(id)
}

    /**
    Реализация перехода
    p.s Добавить анимацию нужно!(Мне лень, поэтому Урмат это твоя задача!)
     */
    private fun navigateDetails(id: String) {
        val action = ParticipantsFragmentDirections.actionParticipantsFragmentToDetailsFragment(id)
        findNavController().navigate(action)
    }
}
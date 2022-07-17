package com.siroca.twiceapp.ui.fragment.participants

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.domain.participants.entity.ParticipantEntity
import com.siroca.twiceapp.databinding.FragmentParticipantsBinding
import com.siroca.twiceapp.ui.fragment.participants.adapter.ParticipantsAdapter
import dagger.hilt.android.AndroidEntryPoint

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
    }

    override fun setupObservers() {
        super.setupObservers()
        observeParticipants()
    }

    private fun observeParticipants() {
    }

    private fun handleParticipants(list: List<ParticipantEntity>) {
        adapter.list = list
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
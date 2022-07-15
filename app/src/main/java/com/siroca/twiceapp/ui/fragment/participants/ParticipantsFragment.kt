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
        ParticipantsAdapter(this)
    }
    private val viewModel by viewModels<ParticipantsViewModel>()

    override fun setupUI() {
        initAdapter()
        initData()
    }

    override fun setupObservers() {
        super.setupObservers()
        observeParticipants()
    }

    /**
    Получения данных из ViewModel
    p.s
    схема написанная ниже работает так же только в обратную сторону
     */
    private fun observeParticipants() {

    }

    private fun handleParticipants(list: List<ParticipantEntity>) {
        adapter.list = list
    }

    /**
    Запрос через ViewModel , viewModel в свою очередь дергает domain слой ,
    domain cлой дергает data слой, и только через data слой осуществляется запрос на сервер
     **/
    private fun initData() {

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
package com.siroca.twiceapp.ui.fragment.ribbon

import androidx.fragment.app.viewModels
import com.example.core.base.BaseFragment
import com.example.domain.ribbon.entity.RibbonEntity
import com.siroca.twiceapp.databinding.FragmentRibbonBinding
import com.siroca.twiceapp.ui.fragment.ribbon.adapter.RibbonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RibbonFragment : BaseFragment<FragmentRibbonBinding>(FragmentRibbonBinding::inflate) {

    private val adapter: RibbonAdapter by lazy {
        RibbonAdapter()
    }
    private val viewModel by viewModels<RibbonViewModel>()

    override fun setupUI() {
        initAdapter()
        initData()
    }

    override fun setupObservers() {
        super.setupObservers()
        observeRibbon()
    }

    /**
    Получения данных из ViewModel
    p.s
    схема написанная ниже работает так же только в обратную сторону
     */
    private fun observeRibbon() {

    }

    /**
    Запрос через ViewModel , viewModel в свою очередь дергает domain слой ,
    domain cлой дергает data слой, и только через data слой осуществляется запрос на сервер
     */
    private fun initData() {

    }

    private fun handleRibbon(list: List<RibbonEntity>) {
        adapter.list = list
    }

    private fun initAdapter() {
        requireBinding().rvRb.adapter = adapter
    }

}
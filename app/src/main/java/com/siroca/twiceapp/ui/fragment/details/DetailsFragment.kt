package com.siroca.twiceapp.ui.fragment.details

import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.siroca.twiceapp.databinding.FragmentDetailsBinding


class DetailsFragment : BaseFragment<FragmentDetailsBinding>(
    FragmentDetailsBinding::inflate
) {

    private val arguments: DetailsFragmentArgs by navArgs()

    override fun setupUI() {
        initData(arguments.id)
    }

    /**
     *  Запрос через ViewModel , viewModel в свою очередь дергает domain слой ,
    domain cлой дергает data слой, и только через data слой осуществляется запрос на сервер
     */
    private fun initData(id: String) {

    }

}
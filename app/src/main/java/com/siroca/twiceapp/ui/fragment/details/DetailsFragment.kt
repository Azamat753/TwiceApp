package com.siroca.twiceapp.ui.fragment.details

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.base.BaseFragment
import com.example.domain.participants.entity.ParticipantEntity
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.FragmentDetailsBinding
import com.siroca.twiceapp.ui.fragment.participants.ParticipantsFragmentDirections
import com.siroca.twiceapp.ui.fragment.participants.ParticipantsViewModel
import com.siroca.twiceapp.ui.fragment.participants.adapter.ParticipantsAdapter

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(
    FragmentDetailsBinding::inflate
), ParticipantsAdapter.Result {

    private val arguments: DetailsFragmentArgs by navArgs()
    private val adapter: ParticipantsAdapter by lazy {
        ParticipantsAdapter(this)
    }
    private val viewModel by viewModels<ParticipantsViewModel>()
    private val viewModels by viewModels<DetailsViewModel>()


    override fun setupUI() {
        initData(arguments.id)
    }

    override fun setupObservers() {
        super.setupObservers()
        observeDetails()
        initAdapter()
        toFactFragment()
        toPhotosFragment()
    }

    /**
     *  Запрос через ViewModel , viewModel в свою очередь дергает domain слой ,
    domain cлой дергает data слой, и только через data слой осуществляется запрос на сервер
     */
    private fun initData(id: String) {

    }

    private fun toFactFragment(){
        requireBinding().btnFacts.setOnClickListener {
            findNavController().navigate(R.id.factsFragment)
        }
    }

    private fun observeDetails() {
    }

    private fun handleDetails(list: List<ParticipantEntity>) {
        adapter.list = list
    }

    private fun initAdapter() {
        requireBinding().rvOtherParticipants.adapter = adapter
    }

    private fun toPhotosFragment(){
        requireBinding().btnPhotos.setOnClickListener{
            findNavController().navigate(R.id.photoFragment)
        }
    }

    override fun onClickListener(id: String) {
        navigateDetails(id)
    }

    private fun navigateDetails(id: String) {
        val action = ParticipantsFragmentDirections.actionParticipantsFragmentToDetailsFragment(id)
        findNavController().navigate(action)
    }

}
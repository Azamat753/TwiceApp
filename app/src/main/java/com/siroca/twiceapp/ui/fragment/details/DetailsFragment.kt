package com.siroca.twiceapp.ui.fragment.details

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.core.base.BaseFragment
import com.example.domain.detail.entity.DetailEntity
import com.example.domain.participants.entity.ParticipantEntity
import com.siroca.twiceapp.databinding.FragmentDetailsBinding
import com.siroca.twiceapp.ui.fragment.participants.adapter.ParticipantsAdapter


class DetailsFragment : BaseFragment<FragmentDetailsBinding>(
    FragmentDetailsBinding::inflate
), ParticipantsAdapter.Result {

    private val arguments: DetailsFragmentArgs by navArgs()

    private val adapter: ParticipantsAdapter by lazy {
        ParticipantsAdapter(this, false)
    }

    private val viewModels by viewModels<DetailsViewModel>()

    private var idFacts = ""

    private var idImages = ""

    private var id = ""

    private var isOpened = false

    override fun setupUI() {
        initData()
        initAdapter()
        initBtn()
        initOpen()
    }

    override fun setupObservers() {
        super.setupObservers()
        observeDetails()
    }


    private fun initOpen() {
        isOpened = true
    }

    /**
     *  Запрос через ViewModel , viewModel в свою очередь дергает domain слой ,
    domain cлой дергает data слой, и только через data слой осуществляется запрос на сервер
     */
    private fun initData() {
        initInfo(arguments.id)
    }

    private fun initInfo(argId: String) {
        if (!isOpened) {
            initDetail(argId)
            initParticipants(argId)
        } else {
            initDetail(id)
            initParticipants(id)
        }
    }

    private fun initDetail(id: String) {

    }

    private fun initBtn() {
        requireBinding().btnPhotos.setOnClickListener {
            navigatePhoto()
        }
        requireBinding().btnFacts.setOnClickListener {
            navigateFacts()
        }
    }

    private fun navigateFacts() {
        val action = DetailsFragmentDirections.actionDetailsFragmentToFactsFragment(idFacts)
        findNavController().navigate(action)
    }

    private fun navigatePhoto() {
        val action = DetailsFragmentDirections.actionDetailsFragmentToPhotoFragment(idImages)
        findNavController().navigate(action)
    }

    private fun observeDetails() {
        TODO()
    }

    private fun handleParticipants(list: List<ParticipantEntity>) {
        adapter.list = list
    }

    private fun handleDetails(detailEntity: DetailEntity) {
        initId(detailEntity.idFacts, detailEntity.idImages, detailEntity.id)
        initView(detailEntity)
    }

    private fun initView(detailEntity: DetailEntity) = with(requireBinding()) {
        txtNick.text = detailEntity.nickName
        imgMainPic.load(detailEntity.images[0])
        imgFirstPic.load(detailEntity.images[1])
        imgSecondPic.load(detailEntity.images[2])
        txtRealNameFirst.text = detailEntity.realNamesFirst
        txtRealNameSecond.text = detailEntity.realNamesSecond
        txtOtherName.text = detailEntity.nickName
        txtBirthday.text = detailEntity.birthday
        txtPlaceBirthday.text = detailEntity.placeBirthday
        txtEducation.text = detailEntity.education
        txtCar.text = detailEntity.career
        txtHeight.text = detailEntity.height
        txtWeight.text = detailEntity.weight
    }

    private fun initId(idFacts: String, idImages: String, id: String) {
        this.id = id
        this.idFacts = idFacts
        this.idImages = idImages
    }

    private fun initAdapter() {
        requireBinding().rvOthers.adapter = adapter
    }

    override fun onClickListener(id: String) {
        initDetail(id)
        initParticipants(id)
    }

    private fun initParticipants(id: String) {
        TODO("Not yet implemented")
    }

}
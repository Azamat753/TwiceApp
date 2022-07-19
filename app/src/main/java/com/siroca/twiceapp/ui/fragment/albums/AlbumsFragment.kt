package com.siroca.twiceapp.ui.fragment.albums

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.domain.albums.entity.AlbumsEntity
import com.siroca.twiceapp.databinding.FragmentAlbumsBinding
import com.siroca.twiceapp.ui.fragment.albums.adapter.AlbumsAdapter

class AlbumsFragment : BaseFragment<FragmentAlbumsBinding>(
    FragmentAlbumsBinding::inflate
), AlbumsAdapter.Result {

    private val adapter: AlbumsAdapter by lazy {
        AlbumsAdapter(this, true)
    }
    private val viewModel by viewModels<AlbumsViewModel>()

    override fun setupUI() {
        initAdapter()
        initData()
    }

    override fun setupObservers() {
        super.setupObservers()
        observeParticipants()
    }

    private fun observeParticipants() {
    }

    private fun handleAlbums(list: List<AlbumsEntity>) {
        adapter.list = list
    }

    private fun initData() {
    }

    private fun initAdapter() {
        requireBinding().rvAlbums.adapter = adapter
    }

    override fun onClickListener(id: String) {
        navigateAlbums(id)
    }

    private fun navigateAlbums(id: String) {
        val action = AlbumsFragmentDirections.actionAlbumsFragmentToBuyFragment(id)
        findNavController().navigate(action)
    }
}
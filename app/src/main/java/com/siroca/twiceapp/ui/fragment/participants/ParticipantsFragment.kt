package com.siroca.twiceapp.ui.fragment.participants

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.FragmentParticipantsBinding
import com.siroca.twiceapp.ui.fragment.participants.adapter.ParticipantsAdapter
import com.siroca.twiceapp.ui.fragment.participants.model.ParticipantsModel

class ParticipantsFragment : BaseFragment<FragmentParticipantsBinding>(FragmentParticipantsBinding::inflate),
    ParticipantsAdapter.Listener {

    private lateinit var adapter: ParticipantsAdapter
    private val navController: NavController by lazy {
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container)
                    as NavHostFragment
        navHostFragment.navController
    }

    override fun setupUI() {
        init()
    }

    private fun init(){
        adapter = ParticipantsAdapter(this)
        val list = ParticipantsModel("Цзуи", "Вижуал", R.drawable.participants)
        requireBinding().rvParticipants.adapter = adapter
        adapter.addRibbon(list)
    }

    override fun onClick(pos: Int) {
        adapter.getModel(pos)
        navController.navigate(R.id.detailsFragment)
    }


}
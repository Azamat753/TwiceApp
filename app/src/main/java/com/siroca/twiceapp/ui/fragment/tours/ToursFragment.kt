package com.siroca.twiceapp.ui.fragment.tours

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.core.base.BaseFragment
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.FragmentToursBinding


class ToursFragment : BaseFragment<FragmentToursBinding>(
    FragmentToursBinding::inflate
) {
    private val navController: NavController by lazy {
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navHostFragment.navController
    }
    override fun setupUI() {
        requireBinding().btnDd.setOnClickListener{
            navController.navigate(R.id.photoFragment)
        }
    }

}
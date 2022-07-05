package com.siroca.twiceapp.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.ActivityMainBinding
import com.siroca.twiceapp.utils.ext.gone
import com.siroca.twiceapp.utils.ext.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navHostFragment.navController
    }
    private val list = arrayOf(
        R.id.detailsFragment,
        R.id.photoFragment,
        R.id.factsFragment,
        R.id.checkoutFragment,
        R.id.buyFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initBottomNav()
        controllerObserve()
    }

    private fun controllerObserve() {
        navController.addOnDestinationChangedListener { _, dest, _ ->
            if (dest.id != R.id.buyFragment) {
                binding.txtMain.text = dest.label
            }
            if (list.contains(dest.id))
                binding.bottomNav.gone()
            else
                binding.bottomNav.visible()

        }
    }

    private fun initBottomNav() {
        binding.bottomNav.apply {
            setupWithNavController(navController)
            itemIconTintList = null
        }
    }
}
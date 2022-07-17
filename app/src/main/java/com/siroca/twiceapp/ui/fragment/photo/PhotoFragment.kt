package com.siroca.twiceapp.ui.fragment.photo

import androidx.viewpager2.widget.ViewPager2
import com.example.core.base.BaseFragment
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.ActivityMainBinding
import com.siroca.twiceapp.databinding.FragmentPhotoBinding
import com.siroca.twiceapp.ui.fragment.photo.adapter.AdapterForViewPager


class PhotoFragment : BaseFragment<FragmentPhotoBinding>(FragmentPhotoBinding::inflate) {

    private var images = mutableListOf<Int>()

    private val binding: FragmentPhotoBinding by lazy {
        FragmentPhotoBinding.inflate(layoutInflater)
    }

    override fun setupUI() {
        postToList()
          initVP()
    }

    private fun initVP() {
        binding.photoVp.adapter = AdapterForViewPager(images)
        binding.photoVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun addToLost(image: Int){
        images.add(image)
    }

    private fun postToList(){
        for (i in 1..3){
            addToLost(R.mipmap.ic_launcher_round)
        }
    }

}

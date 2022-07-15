package com.siroca.twiceapp.ui.fragment.ribbon

import com.example.core.base.BaseFragment
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.FragmentRibbonBinding
import com.siroca.twiceapp.ui.fragment.ribbon.adapter.RibbonAdapter
import com.siroca.twiceapp.ui.fragment.ribbon.model.RibbonModel

class RibbonFragment : BaseFragment<FragmentRibbonBinding>(FragmentRibbonBinding::inflate) {

    private val adapter = RibbonAdapter()

    override fun setupUI() {
        init()
    }

    private fun init(){
        val list = RibbonModel("Amet minim mollit", "Non deserunt ullamco est sit" +
                "aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit.",
            R.drawable.twice)
        requireBinding().rvItem.adapter = adapter
        adapter.addRibbon(list)
    }
}
package com.example.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val binder: (LayoutInflater, ViewGroup?, Boolean) -> VB
) :
    Fragment(
    ) {
    private var binding: VB? = null

    protected fun requireBinding(): VB {
        return checkNotNull(binding)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = binder.invoke(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
    }


    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    abstract fun setupUI()

    protected open fun setupObservers() {}
}
package com.storezaap.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.storezaap.R
import com.storezaap.databinding.FragmentHomeBinding
import com.storezaap.ui.base.BaseFragment


class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private var _binding:FragmentHomeBinding?=null
    private val  binding get() = _binding!!

    override fun initClicks() {
    }

    override fun initMethods() {
    }

    override fun initViews(view: View) {
        _binding=FragmentHomeBinding.bind(view)
    }

    override fun onClick(v: View?) {
    }
}
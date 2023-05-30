package com.storezaap.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.storezaap.R
import com.storezaap.databinding.FragmentHomeBinding
import com.storezaap.ui.base.BaseFragment


class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private var _binding:FragmentHomeBinding?=null
    private val  binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    override fun initClicks() {
    }

    override fun initMethods() {
        observeData()
    }

    private fun observeData(){
        homeViewModel.slideList.observe(viewLifecycleOwner){
            if(it==null){
                return@observe
            }
            binding.imageSlider.setImageList(it, ScaleTypes.FIT)
        }
        homeViewModel.brandimages.observe(viewLifecycleOwner){
            if(it==null){
                return@observe
            }
        }
        homeViewModel.brandData.observe(viewLifecycleOwner){
            if(it==null){
                return@observe
            }
        }

    }

    override fun initViews(view: View) {
        _binding=FragmentHomeBinding.bind(view)
        homeViewModel=ViewModelProvider(viewModelStore,HomeViewModelFactory())[HomeViewModel::class.java]
    }

    override fun onClick(v: View?) {
    }
}
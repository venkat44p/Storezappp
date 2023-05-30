package com.storezaap.ui.home

import android.content.Intent
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
import com.storezaap.ui.store.StoreActivity


class HomeFragment : BaseFragment(R.layout.fragment_home),BrandImageAdapter.ImageItemClickListener {

    private var _binding:FragmentHomeBinding?=null
    private val  binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var brandAdapter: BrandAdapter
    private lateinit var brandImageAdapter: BrandImageAdapter

    override fun initClicks() {
    }

    override fun initMethods() {
        observeData()
        homeViewModel.getHomeData()
    }

    private fun observeData(){
        homeViewModel.slideList.observe(viewLifecycleOwner){
            if(it==null){
                return@observe
            }
            binding.imageSlider.setImageList(it, ScaleTypes.FIT)
        }
        homeViewModel.brandImages.observe(viewLifecycleOwner){
            if(it==null){
                return@observe
            }
            brandImageAdapter.updateBrandImages(it)

        }
        homeViewModel.brandData.observe(viewLifecycleOwner){
            if(it==null){
                return@observe
            }
            brandAdapter.updateBrand(it)

        }

    }

    override fun initViews(view: View) {
        _binding=FragmentHomeBinding.bind(view)
        homeViewModel=ViewModelProvider(viewModelStore,HomeViewModelFactory())[HomeViewModel::class.java]
        brandAdapter= BrandAdapter()
        brandImageAdapter= BrandImageAdapter(this@HomeFragment)
        binding.brandAdapter=brandAdapter
        binding.brandImageAdapter=brandImageAdapter
    }

    override fun onClick(v: View?) {
    }

    override fun onImageItemClicked(category: String) {
        val storeIntent=Intent(requireContext(),StoreActivity::class.java)
        storeIntent.putExtra(StoreActivity.CATEGORY_EXTRA,category)
        startActivity(storeIntent)
    }

}
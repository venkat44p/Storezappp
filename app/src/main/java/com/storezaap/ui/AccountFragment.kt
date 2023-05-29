package com.storezaap.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.storezaap.R
import com.storezaap.databinding.FragmentAccountBinding
import com.storezaap.ui.base.BaseFragment


class AccountFragment : BaseFragment(R.layout.fragment_account) {

    private var _binding:FragmentAccountBinding?=null
    private val binding get() = _binding!!

    override fun initClicks() {
    }

    override fun initMethods() {
    }

    override fun initViews(view: View) {
        _binding=FragmentAccountBinding.bind(view)
    }

    override fun onClick(v: View?) {
    }


    companion object
    {
        private const val TAG="AccountFragment"
    }


}
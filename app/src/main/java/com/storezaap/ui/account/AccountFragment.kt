package com.storezaap.ui.account

import android.view.View
import com.storezaap.R
import com.storezaap.data.DataHelper
import com.storezaap.databinding.FragmentAccountBinding
import com.storezaap.ui.MainActivity
import com.storezaap.ui.base.BaseFragment


class AccountFragment : BaseFragment(R.layout.fragment_account) {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    private var screenMode = if (DataHelper.isLoggedIn) ScreenMode.ACCOUNT else ScreenMode.LOG_IN

    override fun initClicks() {
    }

    override fun initMethods() {
    }

    override fun initViews(view: View) {
        _binding = FragmentAccountBinding.bind(view)
    }

    override fun onClick(v: View?) {
    }

    override fun onStart() {
        if (screenMode == ScreenMode.ACCOUNT) {
            onAccountScreenMode()
        } else {
            onLoginScreenMode()
        }
        super.onStart()
    }

    private fun onLoginScreenMode() {
        (requireActivity() as MainActivity).supportActionBar?.title = "Login"
        binding.accountContainer.visibility = View.GONE
        binding.logInContainer.visibility = View.VISIBLE
    }

    private fun onAccountScreenMode() {
        (requireActivity() as MainActivity).supportActionBar?.title = "Account"
        binding.logInContainer.visibility = View.GONE
        binding.accountContainer.visibility = View.VISIBLE
    }


    companion object {
        private const val TAG = "AccountFragment"
    }

    private enum class ScreenMode {
        LOG_IN,
        ACCOUNT
    }


}
package com.storezaap.ui

import android.view.View
import com.storezaap.R
import com.storezaap.databinding.FragmentNewsBinding
import com.storezaap.ui.base.BaseFragment


class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun initClicks() {
    }

    override fun initMethods() {

    }

    override fun initViews(view: View) {
        _binding = FragmentNewsBinding.bind(view)

        binding.webView.apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
            }
            loadUrl(NEWS_URL)
        }

    }

    override fun onClick(v: View?) {

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        private const val TAG = "NewsFragment"
        private const val NEWS_URL = "https://storezaap.com/news/Homepage"
    }


}
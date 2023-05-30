package com.storezaap.ui

import android.view.View
import com.storezaap.databinding.ActivityServicesBinding
import com.storezaap.ui.base.BaseActivity

class ServicesActivity : BaseActivity() {

    private lateinit var binding: ActivityServicesBinding

    override fun initClicks() {

    }

    override fun initMethods() {

    }

    override fun initViews() {
        binding = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(v: View?) {

    }


}
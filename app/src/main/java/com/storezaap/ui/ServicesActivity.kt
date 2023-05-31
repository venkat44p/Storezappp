package com.storezaap.ui

import android.view.MenuItem
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

        setSupportActionBar(binding.toolBar.toolBar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title="Services"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {

    }


}
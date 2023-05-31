package com.storezaap.ui

import android.view.MenuItem
import android.view.View
import com.storezaap.databinding.ActivityPrivacyPolicyBinding
import com.storezaap.ui.base.BaseActivity

class PrivacyPolicyActivity : BaseActivity() {

    private lateinit var binding: ActivityPrivacyPolicyBinding

    override fun initClicks() {

    }

    override fun initMethods() {

    }

    override fun initViews() {
        binding = ActivityPrivacyPolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar.toolBar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title="Privacy Policy"
        }

        binding.webView.apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
            }
            loadUrl(PRIVACY_POLICY_URL)
        }

    }


    override fun onClick(v: View?) {

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

    companion object {
        private const val PRIVACY_POLICY_URL = "https://storezaap.com/privacy.php"
    }


}
package com.storezaap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.storezaap.databinding.ActivityPrivacyPolicyBinding
import com.storezaap.ui.base.BaseActivity

class PrivacyPolicyActivity : BaseActivity() {

    private lateinit var binding:ActivityPrivacyPolicyBinding

    override fun initClicks() {

    }

    override fun initMethods() {

    }

    override fun initViews() {
        binding=ActivityPrivacyPolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
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

    companion object{
        private const val PRIVACY_POLICY_URL="https://storezaap.com/privacy.php"
    }


}
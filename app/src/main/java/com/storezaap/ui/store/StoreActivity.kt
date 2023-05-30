package com.storezaap.ui.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.storezaap.R
import com.storezaap.databinding.ActivityStoreBinding
import com.storezaap.ui.base.BaseActivity

class StoreActivity : BaseActivity() {


    private lateinit var binding:ActivityStoreBinding

    override fun initClicks() {

    }

    override fun initMethods() {

    }

    override fun initViews() {
        binding=DataBindingUtil.setContentView(this, R.layout.activity_store)
    }

    override fun onClick(v: View?) {

    }


}
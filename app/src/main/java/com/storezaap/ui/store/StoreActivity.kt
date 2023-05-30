package com.storezaap.ui.store

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.storezaap.R
import com.storezaap.data.BrandCategory
import com.storezaap.databinding.ActivityStoreBinding
import com.storezaap.ui.base.BaseActivity

class StoreActivity : BaseActivity() {


    private lateinit var binding: ActivityStoreBinding
    private var category: String? = null

    private lateinit var storeViewModel: StoreViewModel

    override fun initClicks() {

    }

    override fun initMethods() {
        observeData()
    }

    private fun observeData(){

    }

    override fun initViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_store)

        storeViewModel=ViewModelProvider(this,StoreViewModelFactory())[StoreViewModel::class.java]

        intent?.let {
            category = it.getStringExtra(CATEGORY_EXTRA)
        }

        if(category==null ){
            category=BrandCategory.AMAZON
        }

    }

    override fun onClick(v: View?) {

    }

    companion object {
        private const val TAG = "StoreActivity"
        const val CATEGORY_EXTRA = "category_extra"
    }


}
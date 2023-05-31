package com.storezaap.ui.store

import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.storezaap.R
import com.storezaap.data.BrandCategory
import com.storezaap.databinding.ActivityStoreBinding
import com.storezaap.ui.base.BaseActivity
import com.storezaap.utils.makeToast

class StoreActivity : BaseActivity() {


    private lateinit var binding: ActivityStoreBinding
    private var category: String? = null

    private lateinit var storeViewModel: StoreViewModel
    private lateinit var storeAdapter: StoreAdapter

    private val storeTitle: String
        get() {
            return when (category) {
                BrandCategory.AMAZON -> "Amazon"
                BrandCategory.EBAY -> "E-bay"
                BrandCategory.FIRSTCRY -> "FirstCry"
                BrandCategory.FLIPKART -> "Flipkart"
                BrandCategory.INFIBEAM -> "InfiBeam"
                BrandCategory.LIMEROAD -> "LimeRoad"
                BrandCategory.SHOPCLUES -> "ShopClues"
                BrandCategory.SNAPDEAL -> "SnapDeal"
                else -> "Amazon"
            }
        }

    override fun initClicks() {

    }

    override fun initMethods() {
        observeData()
        storeViewModel.getStoreData(category ?: BrandCategory.AMAZON)
    }

    private fun observeData() {
        storeViewModel.storeData.observe(this) {
            if (it == null) {
                return@observe
            }

            if (it.error != null) {
                makeToast(it.error)
            } else if (it.success != null) {
                storeAdapter.updateStore(it.success)
            }

        }
    }

    override fun initViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_store)


        setSupportActionBar(binding.toolBar.toolBar)

        storeViewModel =
            ViewModelProvider(this, StoreViewModelFactory())[StoreViewModel::class.java]
        storeAdapter = StoreAdapter()
        binding.storeAdapter = storeAdapter

        intent?.let {
            category = it.getStringExtra(CATEGORY_EXTRA)
        }

        if (category == null) {
            category = BrandCategory.AMAZON
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = storeTitle
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
        private const val TAG = "StoreActivity"
        const val CATEGORY_EXTRA = "category_extra"
    }

}
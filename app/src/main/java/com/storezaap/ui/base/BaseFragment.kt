package com.storezaap.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.storezaap.R


abstract class BaseFragment(@LayoutRes val layoutContainerId:Int) : Fragment(layoutContainerId), OnClickListener {

    abstract fun initClicks()
    abstract fun initMethods()
    abstract fun initViews(view: View)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initClicks()
        initMethods()
    }

}
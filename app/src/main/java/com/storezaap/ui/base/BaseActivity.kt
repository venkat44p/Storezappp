package com.storezaap.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener

abstract class BaseActivity : AppCompatActivity() ,OnClickListener{

    abstract fun initClicks()
    abstract fun initMethods()
    abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initClicks()
        initMethods()
    }


}
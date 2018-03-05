package com.example.fengxin.mykotlinproject

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import com.example.fengxin.mykotlinproject.ViewModel.ViewModel

abstract class MvvmActivity : AppCompatActivity() {

    private var binding: ViewDataBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLayoutResId())

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    protected abstract fun createViewModel(): ViewModel
    @LayoutRes protected abstract fun getLayoutResId(): Int
}

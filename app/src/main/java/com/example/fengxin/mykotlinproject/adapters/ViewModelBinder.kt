package com.example.fengxin.mykotlinproject.adapters

import com.example.fengxin.mykotlinproject.ViewModel.ViewModel

/**
 * Created by fengxin on 02/03/2018.
 */
interface ViewModelBinder {
    fun bind(viewModelBinder: ViewModelBinder?,viewModel: ViewModel?)
}
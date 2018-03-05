package com.example.fengxin.mykotlinproject

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

/**
 * Created by fengxin on 23/02/2018.
 */
object ToastExtension {

    fun Context.toast(@StringRes message: Int) =
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    fun Context.toast(message: CharSequence) =
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    fun Context.toastLong(@StringRes message: Int) =
            Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    fun Context.toastLong(message: CharSequence) =
            Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}

package com.example.fengxin.mykotlinproject.ViewModel

import android.util.Log
import android.widget.Toast
import io.reactivex.functions.Action

/**
 * Created by fengxin on 01/03/2018.
 */
class MainViewModel : ViewModel{

    val zxing_activity_click = Action  {
        Log.e("MainViewModel : ","MainViewModel")
    }

}
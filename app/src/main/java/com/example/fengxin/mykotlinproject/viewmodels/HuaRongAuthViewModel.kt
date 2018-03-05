package com.example.fengxin.mykotlinproject.viewmodels

import com.example.fengxin.mykotlinproject.controllers.AuthController
import java.util.*

/**
 * Created by fengxin on 23/02/2018.
 */
class HuaRongAuthViewModel(private val authController: AuthController) : ViewModel{

//    val authorizedUserName = authController.usernameObservable.to
     val USERNAME = "yangxingchen"
     val PASSWORD = "12345678"

    var userName = "yangxingchen"
    var password = "12345678"

}
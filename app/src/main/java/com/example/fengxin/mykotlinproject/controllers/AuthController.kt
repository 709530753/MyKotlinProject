package com.example.fengxin.mykotlinproject.controllers

import android.content.Context
import android.content.pm.PackageInstaller
import android.database.Observable

/**
 * Created by fengxin on 24/02/2018.
 */
interface AuthController {

    val context: Context
    val hasToken: Boolean
    val tokenObservable: Observable<Boolean>
    val usernameObservable: Observable<String>
    val progressObservable:Observable<Boolean>
    val activeCodeObservable:Observable<Boolean>

    fun requestActiveCode(usrename: String, password: String, endpoint: String)
    fun requestAuthorization(username: String, password: String, domaincode: String, activeCoded: String, endpoint: String)
    fun login(username: String, password: String, domaincode: String, activeCoded: String, endpoint: String)
    fun authorizationDevice(username: String, password: String, domaincode: String, activeCoded: String, session: PackageInstaller.SessionInfo)

}
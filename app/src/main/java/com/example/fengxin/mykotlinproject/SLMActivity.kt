package com.example.fengxin.mykotlinproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.content_main.*
import com.example.fengxin.mykotlinproject.ToastExtension.toast
import com.example.fengxin.mykotlinproject.viewmodels.HuaRongAuthViewModel

class SLMActivity : AppCompatActivity() {

    private final var TAG = "SLMActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slm)

        scan_qr_code_to_auth.setOnClickListener{
            toast(TAG + " : scan_qr_code_to_auth")
        }

        username.setText("yangxingchen")
        password.setText("123456789")
    }

    companion object {

        fun startSLMActivity(context: Activity) {
            var intent = Intent(context,SLMActivity::class.java)
            context.startActivity(intent)
        }
    }
}

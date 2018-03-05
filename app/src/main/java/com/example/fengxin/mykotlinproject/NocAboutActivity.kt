package com.example.fengxin.mykotlinproject

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class NocAboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noc_about)
        title = "about"
    }

    companion object {

        fun startNocAboutActivity(context : Activity) {
            var intent = Intent(context,NocAboutActivity::class.java)
            context.startActivity(intent)
        }

    }

}

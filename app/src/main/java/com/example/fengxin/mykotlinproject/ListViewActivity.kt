package com.example.fengxin.mykotlinproject

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fengxin.mykotlinproject.ToastExtension.toast

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        toast("ListViewActivity")

    }

    companion object {

        fun startListViewActivity(context:Activity) {
            val intent = Intent(context, ListViewActivity::class.java)
            context.startActivity(intent)
        }
    }

}

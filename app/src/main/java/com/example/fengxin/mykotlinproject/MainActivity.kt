package com.example.fengxin.mykotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.app_bar_main.*
import com.example.fengxin.mykotlinproject.ToastExtension.toast
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            toast("fab_click")
            NocAboutActivity.startNocAboutActivity(this)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId) {
            R.id.action_manage_configurations -> {
                toast("aaaaaaaaaaaaaaaaaaaaaaaa")
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val draw = drawer_layout
        draw.closeDrawer(GravityCompat.START)
        draw.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
                when(item.itemId) {

                    R.id.nav_about -> {
                        showAboutUs()
                    }

                    R.id.nav_feedback -> {
                        showFeedBack()
                    }
                }
                draw.removeDrawerListener(this)
            }
        })

        return true
    }

    fun showAboutUs() {
        toast("showAboutUs")
    }

    fun showFeedBack() {
        toast("showFeedBack")
    }

}

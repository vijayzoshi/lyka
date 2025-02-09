package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.adapter.SessionPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SessionActivity : AppCompatActivity() {


    lateinit var sessionTb : TabLayout
    lateinit var sessionVp : ViewPager2
    lateinit var sessionPageAdapter: SessionPageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)



        sessionTb = findViewById(R.id.tb_sessions)
        sessionVp = findViewById(R.id.vp_sessions)

        sessionPageAdapter = SessionPageAdapter(supportFragmentManager, lifecycle)
        sessionVp.adapter = sessionPageAdapter


        TabLayoutMediator(sessionTb, sessionVp) { tab, position ->

            when(position){
                0 -> {
                    tab.text = "Upcoming"
                }

                1 -> {
                    tab.text = "Completed"
                }
            }
        }.attach()



    }
}
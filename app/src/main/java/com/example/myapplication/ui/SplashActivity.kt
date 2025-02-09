package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.google.android.material.button.MaterialButtonToggleGroup

class SplashActivity : AppCompatActivity() {


    // private lateinit var viewpager : ViewPager2
    //private lateinit var pageradapter : ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        /*
        class ViewPagerAdapter : RecyclerView.Adapter<ViewHolder>(){

        }

        class viewholder(itemview : View) : RecyclerView.ViewHolder(itemview){

        }

         */

        val toggleButton : MaterialButtonToggleGroup = findViewById(R.id.toggleButton)

        toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
            // Respond to button selection
        }
    }
}


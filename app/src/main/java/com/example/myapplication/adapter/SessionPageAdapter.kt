package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.CompletesessionFragment
import com.example.myapplication.UpcomingsessionFragment

class SessionPageAdapter(fragmentManager : FragmentManager, lifecycle : Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle)  {
    override fun getItemCount(): Int {
        return 2
    }


    override fun createFragment(position: Int): Fragment {

        if(position ==0){
            return  UpcomingsessionFragment()

        }else{
            return CompletesessionFragment()

        }


        }



}
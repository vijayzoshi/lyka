package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {


    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    //    val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)

        val toolbars = binding.myToolbar
        setSupportActionBar(toolbars)
       // supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val navController : NavController = findNavController(R.id.fragment_main)
        NavigationUI.setupWithNavController(binding.bottomnavigationview, navController)


    }
}

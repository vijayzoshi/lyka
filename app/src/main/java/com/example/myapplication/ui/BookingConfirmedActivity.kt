package com.example.myapplication.ui

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.example.myapplication.R

class BookingConfirmedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_confirmed)

        val lottieView = findViewById<LottieAnimationView>(R.id.lottieView)

        val intent = Intent(this, MainActivity2 :: class.java) // Replace MainActivity with your target


        lottieView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                println("Animation started!")
            }

            override fun onAnimationEnd(animation: Animator) {
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(animation: Animator) {
                println("Animation canceled!")
            }

            override fun onAnimationRepeat(animation: Animator) {
                println("Animation repeated!")
            }
        })



}}

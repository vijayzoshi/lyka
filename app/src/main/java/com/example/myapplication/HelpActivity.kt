package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)




        var callCd = findViewById<CardView>(R.id.cd_callus)
        var chatCd = findViewById<CardView>(R.id.cd_chatus)

        callCd.setOnClickListener {


        }

        chatCd.setOnClickListener {

        }



    }
}
package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySessionDetailsBinding
import com.example.myapplication.model.SessionData
import com.example.myapplication.model.TopExpertsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import kotlin.random.Random

class SessionDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySessionDetailsBinding
    lateinit var databaseRefrence: DatabaseReference
    lateinit var databaseRefrenceuser: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_details)
        binding = ActivitySessionDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val expertid = intent.getStringExtra("expertid").toString()
        val sessiondate = intent.getStringExtra("sessiondate").toString()
        val sessiontime = intent.getStringExtra("sessiontime").toString()
        val patientname = intent.getStringExtra("patientname").toString()
        val sessionmode = intent.getStringExtra("sessionmode").toString()

        binding.tvPatientname.text = patientname
        binding.tvSessionmode.text = sessionmode
        binding.tvSessiondate.text= sessiondate
        binding.tvSessiontime.text = sessiontime



        databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")

        databaseRefrence.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val expert = snapshot.child(expertid).getValue<TopExpertsModel>()
                if (expert != null) {
                    binding.tvExpertname.text = expert.expertname
                    binding.tvExpertdesign.text = expert.expertdesign
                    binding.tvRatings.text = expert.expertrating.toString()
                    binding.tvCharge.text = expert.expertcharge.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })


        databaseRefrenceuser = FirebaseDatabase.getInstance().getReference("users").child("1")



        binding.btnConfirm.setOnClickListener {

            val sessiondata = SessionData(expertid, sessiondate,sessiontime, patientname, sessionmode)

            databaseRefrenceuser.child("sessions").child("upcomingsesions").child(sessionId().toString()).setValue(sessiondata)
            val intent = Intent(this, BookingConfirmedActivity:: class.java)
            startActivity(intent)
            finish()
        }


    }

    fun sessionId(): Int {
        return Random.nextInt(100000, 1000000) // Generates a number from 100000 to 999999
    }



}
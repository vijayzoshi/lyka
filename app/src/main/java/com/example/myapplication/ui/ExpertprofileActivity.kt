package com.example.myapplication.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityExpertprofileBinding
import com.example.myapplication.model.TopExpertsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class ExpertprofileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpertprofileBinding
    lateinit var databaseRefrence: DatabaseReference
    lateinit var lat : String
    lateinit var long : String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expertprofile)



        binding = ActivityExpertprofileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myToolbar.setNavigationOnClickListener() {
            // Handle navigation icon press
            finish()

        }

        val expertid = intent.getIntExtra("expertid",0).toString()

        databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")
        databaseRefrence.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val expert = snapshot.child(expertid).getValue<TopExpertsModel>()
                if (expert != null) {
                    binding.tvExpertname.text = expert.expertname
                    binding.tvExpertdesign.text = expert.expertdesign
                    binding.tvAbout.text = expert.expertabout
                    val exp = expert.expertexp.toString() + " years"
                    binding.tvExpertexp.text = exp
                    binding.tvLanguage.text = expert.expertlang
                    binding.tvMode.text = expert.expertmode
                    binding.tvRatings.text = expert.expertrating.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        //val standardBottomSheet = findViewById<FrameLayout>(R.id.)
        //val standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)

        binding.btnBooknow.setOnClickListener {
            val intent = Intent(this, DateTimeActivity:: class.java)
            intent.putExtra("expertid", expertid)
            startActivity(intent)
        }

        binding.btnVisit.setOnClickListener {   // Create the Uri for the location
            val gmmIntentUri = Uri.parse("geo: $lat, $long")

            // Create the implicit Intent
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            // Set the package to ensure it opens in Google Maps
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent) }


        databaseRefrence.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                binding.tvClinicaddress.text =  snapshot.child(expertid).child("clinic").child("clinic address").getValue<String>()
                lat = snapshot.child(expertid).child("clinic").child("clinic lat").getValue<String>().toString()
                long = snapshot.child(expertid).child("clinic").child("clinic long").getValue<String>().toString()

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )


    }
}
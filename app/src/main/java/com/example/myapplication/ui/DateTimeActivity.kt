package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.model.TopExpertsModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateTimeActivity : AppCompatActivity() {


    private lateinit var databaseReference: DatabaseReference
    lateinit var date :String
    lateinit var time :String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_date_time)


        val nextBtn = findViewById<Button>(R.id.btn_next)
        val sessionCg = findViewById<ChipGroup>(R.id.cg_session)
        val chip1 = findViewById<Chip>(R.id.chip_virtual)
        val chip2 = findViewById<Chip>(R.id.chip_inperson)

        val expertid = intent.getStringExtra("expertid")

         val abc = intent

        nextBtn.setOnClickListener {


            val intent = Intent(this, SessionDetailsActivity:: class.java)
            intent.putExtra("expertid", expertid)
            intent.putExtra("sessiondate", "Monday, Jan 1")
            intent.putExtra("sessiontime", "1:00 A.M.")
            intent.putExtra("patientname", "Vijay Joshi")
            intent.putExtra("sessionmode", "Online")

            startActivity(intent)
        }

        chip1.setOnClickListener {
            Toast.makeText(this, "Chip 1 clicked", Toast.LENGTH_SHORT).show()
        }

        chip2.setOnClickListener {
            Toast.makeText(this, "Chip 2 clicked", Toast.LENGTH_SHORT).show()
        }
/*
        sessionCg.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
/*
            chip.setOnClickListener {
                Toast.makeText(this, checkedId, Toast.LENGTH_SHORT).show()

            }

 */

            chip?.let {
                Toast.makeText(this, "${it.text} selected", Toast.LENGTH_SHORT).show()
            }


        }

 */

       // val firstdateCp = findViewById<Chip>(R.id.cp_firstdate)
        val availabledatesCg = findViewById<ChipGroup>(R.id.cg_availabledates)
        val firstslotCp = findViewById<Chip>(R.id.cp_firstslot)

        databaseReference = FirebaseDatabase.getInstance().getReference("experts")



        for(x  in 0..6) {
            val currentDate = LocalDate.now()
            val newdate = currentDate.plusDays(x.toLong())
            val formatter = DateTimeFormatter.ofPattern("dd MMMM")
            val formattedCurrentDate = newdate.format(formatter)

            val chip = Chip(this)
        //    chip.setTextAppearanceResource(R.style.MyChipStyle) // Apply style

            chip.text = formattedCurrentDate.toString()
            chip.isClickable = true
            chip.isCheckable = true
            chip.chipStrokeWidth = 2F


            availabledatesCg.addView(chip)
        }


        availabledatesCg.setOnCheckedStateChangeListener { group, checkedIds ->


            databaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val booked =  snapshot.child("1").child("availabilty").child("date").child("firstslot").getValue<Boolean>()
                    for(datasnapshot in snapshot.children){
                        val data = datasnapshot.getValue(TopExpertsModel :: class.java)
                    }
                    if(booked == true) {
                     // firstslotCp.setBackgroundColor(R.color.lightpurple)
                        firstslotCp.isClickable = false
                    }

                    firstslotCp.setOnClickListener {
               //         databaseReference.child("date").setValue(                        )


                        time = firstslotCp.text.toString()




                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
            )
        }

    }
}
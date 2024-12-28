package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.adapter.TopExpertAdapter
import com.example.myapplication.databinding.ActivityExpertprofileBinding
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.model.TopExpertsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class ExpertprofileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityExpertprofileBinding
    lateinit var databaseRefrence : DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expertprofile)


        binding = ActivityExpertprofileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myToolbar.setNavigationOnClickListener() {
            // Handle navigation icon press
            finish()

        }

        val expertid = intent.getStringExtra("expertid").toString()

        databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")
        databaseRefrence.addValueEventListener( object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val expert =  snapshot.child("1").getValue<TopExpertsModel>()
                if (expert != null) {
                    binding.tvExpertname.text = expert.expertname
                    binding.tvExpertdesign.text = expert.expertdesign
                    binding.tvAbout.text = expert.about
                    binding.tvExpertexp.text = expert.expertexp.toString()
                    binding.tvLanguage.text = expert.language
                    binding.tvMode.text = expert.mode
                    binding.tvRatings.text = expert.expertrating.toString()



                }


            }
            override fun onCancelled(error: DatabaseError) {
            }
        } )







    }
}
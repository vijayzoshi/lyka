package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.TopExpertAdapter
import com.example.myapplication.model.TopExpertsModel
import com.google.android.material.chip.Chip
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllExpertsActivity : AppCompatActivity() {


    lateinit var expertRecyclerView : RecyclerView
    lateinit var expertAapter : TopExpertAdapter
    lateinit var expertArrayList : ArrayList<TopExpertsModel>
    lateinit var chipPsychologist : Chip
    lateinit var chipPsychiatrist : Chip



    lateinit var databaseRefrence : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_experts)


        var infoIb = findViewById<ImageButton>(R.id.ib_info)
        var filterIb = findViewById<ImageButton>(R.id.ib_filter)
        expertArrayList = ArrayList<TopExpertsModel>()

        chipPsychologist = findViewById(R.id.cp_psychologist)
        chipPsychiatrist = findViewById(R.id.cp_psychiatrist)


        expertRecyclerView = findViewById(R.id.rv_allexperts)
        expertRecyclerView.layoutManager = LinearLayoutManager(this)
        expertArrayList = ArrayList<TopExpertsModel>()

        chipPsychologist.setOnClickListener {

            databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")
        }

        chipPsychiatrist.setOnClickListener {

            databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")
        }




        infoIb.setOnClickListener {

        }


        databaseRefrence.addValueEventListener( object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for(datasnapshot in snapshot.children){


                        val data = datasnapshot.getValue(TopExpertsModel :: class.java)

                        expertArrayList.add(data!!)



                    }

                    expertAapter = TopExpertAdapter(expertArrayList)
                    expertRecyclerView.adapter = expertAapter


                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        } )
    }
}
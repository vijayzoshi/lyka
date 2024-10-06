package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.TopExpertAdapter
import com.example.myapplication.model.TopExpertsModel
import com.google.firebase.database.DatabaseReference
import java.util.ArrayList

class SearchActivity : AppCompatActivity() {


    lateinit var expertRecyclerView : RecyclerView
    lateinit var expertAapter : TopExpertAdapter
    lateinit var expertArrayList : ArrayList<TopExpertsModel>
    lateinit var filteredArrayList : ArrayList<TopExpertsModel>


    lateinit var expertSv : androidx.appcompat.widget.SearchView
    lateinit var databaseRefrence : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        expertArrayList = ArrayList<TopExpertsModel>()
        filteredArrayList = ArrayList<TopExpertsModel>()
        expertRecyclerView = findViewById(R.id.rv_expertss)
        expertRecyclerView.layoutManager = LinearLayoutManager(this)

        expertSv = findViewById(R.id.sv_experts)
/*
        expertSv.setOnQueryTextListener(object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
            //    filter(newText)
                return false
            }
        })
        */


    }
    /*
    fun filter(textinput :String) {
        databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")
        databaseRefrence.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (datasnapshot in snapshot.children) {
                        val data = datasnapshot.getValue(TopExpertsModel::class.java)
                        expertArrayList.add(data!!)
                    }

                    for (item in expertArrayList) {
                        if (item.expertname.lowercase().contains(textinput)) {
                            filteredArrayList.add(item)
                        }
                    }
                    expertAapter = TopExpertAdapter(filteredArrayList)
                    expertRecyclerView.adapter = expertAapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

     */
}

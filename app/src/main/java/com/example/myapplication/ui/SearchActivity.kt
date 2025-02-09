package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.TopExpertAdapter
import com.example.myapplication.model.TopExpertsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList
import java.util.Locale

class SearchActivity : AppCompatActivity() {

    var eventListener: ValueEventListener? = null

    lateinit var expertRecyclerView: RecyclerView
    lateinit var expertAapter: TopExpertAdapter
    lateinit var expertArrayList: ArrayList<TopExpertsModel>
    lateinit var filteredArrayList: ArrayList<TopExpertsModel>
    lateinit var expertSv: SearchView
    lateinit var databaseRefrence: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val toolbar = findViewById<View>(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)


        expertArrayList = ArrayList<TopExpertsModel>()
        filteredArrayList = ArrayList<TopExpertsModel>()
        expertRecyclerView = findViewById(R.id.rv_expertss)


        expertRecyclerView.layoutManager = LinearLayoutManager(this)
        expertAapter = TopExpertAdapter(this@SearchActivity, expertArrayList)
        expertRecyclerView.adapter = expertAapter



        databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")

        eventListener = databaseRefrence.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                expertArrayList.clear()
                for (datasnapshot in snapshot.children) {
                    val data = datasnapshot.getValue(TopExpertsModel::class.java)
                    if (data != null) {
                        expertArrayList.add(data)
                    }
                }
                //      expertAapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        expertSv = findViewById(R.id.sv_experts)
        expertSv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    search(newText)
                }
                return true
            }

        })


    }


    fun search(word: String) {
        val searchList = ArrayList<TopExpertsModel>()
        for (x in expertArrayList) {
            if (x.expertname.lowercase().contains(word.lowercase(Locale.getDefault()))
            ) {
                searchList.add(x)
            }
        }

        expertAapter.searchDataList(searchList)

        if (word.isEmpty()) {
            expertRecyclerView.visibility = View.GONE
        } else {
            expertRecyclerView.visibility = View.VISIBLE

        }


    }
}

package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.UpcomingSessionAdapter
import com.example.myapplication.model.UpcomingSessionModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class UpcomingsessionFragment : Fragment(R.layout.fragment_upcomingsession) {


    lateinit var upcomingsessionRecyclerview: RecyclerView
    lateinit var upcomingsessionArraylist: ArrayList<UpcomingSessionModel>
    lateinit var upcomingsessionAdapter: UpcomingSessionAdapter
    lateinit var databaseRefrence: DatabaseReference
    lateinit var nosessionLinearLayout: LinearLayout


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nosessionLinearLayout = view.findViewById(R.id.ll_nosession)
        upcomingsessionRecyclerview = view.findViewById(R.id.rv_upcomingsession)
        upcomingsessionRecyclerview.layoutManager = LinearLayoutManager(context)
        upcomingsessionArraylist = ArrayList<UpcomingSessionModel>()

        databaseRefrence = FirebaseDatabase.getInstance().getReference("users").child("1").child("sessions").child("upcomingsesions")
        databaseRefrence.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (true) {
                    upcomingsessionRecyclerview.visibility = View.VISIBLE
                    nosessionLinearLayout.visibility = View.GONE

                    for (datasnapshot in snapshot.children) {
                        val data = datasnapshot.getValue(UpcomingSessionModel::class.java)
                        upcomingsessionArraylist.add(data!!)
                    }
                    upcomingsessionAdapter = UpcomingSessionAdapter(requireContext(), upcomingsessionArraylist)
                    upcomingsessionRecyclerview.adapter = upcomingsessionAdapter
                } else {
                    upcomingsessionRecyclerview.visibility = View.GONE
                    nosessionLinearLayout.visibility = View.VISIBLE
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}



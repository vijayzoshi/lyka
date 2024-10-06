package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.AllchatsAdapter
import com.example.myapplication.model.AllChatsmodel
import com.example.myapplication.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChatsFragment : Fragment(R.layout.fragment_chats) {



    lateinit var allchatRecyclerview: RecyclerView
    lateinit var allchatArraylist : ArrayList<AllChatsmodel>
    lateinit var allchatAdapter: AllchatsAdapter
    lateinit var databaseRefrence : DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allchatRecyclerview = view.findViewById(R.id.rv_allchats)
        allchatRecyclerview.layoutManager= LinearLayoutManager(context)
        allchatArraylist = ArrayList<AllChatsmodel>()


        databaseRefrence = FirebaseDatabase.getInstance().getReference("users").child("1").child("expertschat")
        databaseRefrence.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    for(datasnapshot in snapshot.children){

                        val data = datasnapshot.getValue(AllChatsmodel:: class.java)
                        allchatArraylist.add(data!!)
                    }
                    allchatAdapter = AllchatsAdapter(requireContext(), allchatArraylist)
                    allchatRecyclerview.adapter = allchatAdapter

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })



























    }

}
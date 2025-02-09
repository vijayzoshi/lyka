package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.FaqAdapter
import com.example.myapplication.model.FaqModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FaqActivity : AppCompatActivity() {

    lateinit var faqRecyclerview: RecyclerView
    lateinit var faqArraylist : ArrayList<FaqModel>
    lateinit var faqAdapter: FaqAdapter
    lateinit var databaseRefrence : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // installSplashScreen()

        setContentView(R.layout.activity_faq)

        faqRecyclerview = findViewById(R.id.rv_faq)
        faqRecyclerview.layoutManager= LinearLayoutManager(this)
        faqArraylist = arrayListOf<FaqModel>()

        databaseRefrence = FirebaseDatabase.getInstance().getReference("faq")
        databaseRefrence.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(datasnapshot in snapshot.children){

                            val data = datasnapshot.getValue(FaqModel::class.java)
                            faqArraylist.add(data!!)
                    /*    if (data != null) {
                            if("hi" == data.ques) {
                                faqArraylist.add(data)
                            }
                        } */
                    }
                    faqAdapter = FaqAdapter( faqArraylist)
                    faqRecyclerview.adapter = faqAdapter
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })

    }
}


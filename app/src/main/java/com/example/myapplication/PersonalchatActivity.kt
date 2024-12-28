package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.AllchatsAdapter
import com.example.myapplication.adapter.PersonalchatsAdapter
import com.example.myapplication.model.AllChatsmodel
import com.example.myapplication.model.PersonalchatsModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
// import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class PersonalchatActivity : AppCompatActivity() {


    lateinit var sendmsgEt: EditText
    lateinit var sendIb: ImageButton
    lateinit var databaseReference: DatabaseReference
    lateinit var senderid : String
    lateinit var personalchatRecyclerview: RecyclerView
    lateinit var personalchatArraylist : ArrayList<PersonalchatsModel>
    lateinit var personalchatAdapter: PersonalchatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalchat)
/*
        personalchatRecyclerview = findViewById(R.id.rv_personalchats)
        personalchatRecyclerview.layoutManager= LinearLayoutManager(this@PersonalchatActivity)
        personalchatArraylist = ArrayList<PersonalchatsModel>()

        senderid = FirebaseAuth.getInstance().uid.toString()

        sendmsgEt = findViewById(R.id.et_sendmsg)
        sendIb = findViewById(R.id.ib_send)
        databaseReference =
            FirebaseDatabase.getInstance().getReference("users").child("1").child("expertschat")
                .child("1")

        sendIb.setOnClickListener {
            
            val data = PersonalchatsModel(senderid, sendmsgEt.text.toString(), getcurrenttime())
            databaseReference.push().setValue(data)
            sendmsgEt.text.clear()
        }/**/


        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    for(datasnapshot in snapshot.children){

                        val data = datasnapshot.getValue(PersonalchatsModel:: class.java)
                        personalchatArraylist.add(data!!)
                    }
                    personalchatRecyclerview.adapter = PersonalchatsAdapter(this@PersonalchatActivity, personalchatArraylist)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

 */
    }

    private fun getcurrenttime(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("hh:mm a")
        return current.format(formatter)
    }

}
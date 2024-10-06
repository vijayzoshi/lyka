package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class ProfileActivity : AppCompatActivity() {


    lateinit var faqCardview : CardView
    lateinit var helpCardview : CardView
    lateinit var sessionCardview : CardView
    lateinit var logoutCardview : CardView
    lateinit var usernameTv : TextView
    lateinit var usernumberTv : TextView
    lateinit var editIv : ImageView
    lateinit var databaseReference: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        usernameTv = findViewById(R.id.tv_username)
        usernumberTv = findViewById(R.id.tv_usernumber)
        editIv = findViewById(R.id.iv_edit)

        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        databaseReference.addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                usernameTv.text = snapshot.child("1").child("username").getValue<String>()
                usernumberTv.text = snapshot.child("1").child("usernumber").getValue<String>()
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )

        editIv.setOnClickListener {
/*
            val modalBottomSheetDialog = ModelBottomSheetDialog()
            modalBottomSheetDialog.show(supportFragmentManager, ModelBottomSheetDialog.TAG)
*/
        }

        faqCardview = findViewById(R.id.cd_faq)
        faqCardview.setOnClickListener {
           val intent = Intent(this, FaqActivity :: class.java)
           startActivity(intent)
        }


        sessionCardview = findViewById(R.id.cd_session)
        sessionCardview.setOnClickListener {
            val intent = Intent(this, SessionActivity :: class.java)
            startActivity(intent)
        }


        helpCardview = findViewById(R.id.cd_help)
        helpCardview.setOnClickListener {
            val intent = Intent(this, HelpActivity :: class.java)
            startActivity(intent)
        }

        logoutCardview = findViewById(R.id.cd_logout)
        logoutCardview.setOnClickListener {

        }

    }
}
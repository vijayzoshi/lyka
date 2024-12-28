package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.myapplication.FaqActivity
import com.example.myapplication.HelpActivity
import com.example.myapplication.ModelBottomSheetDialog
import com.example.myapplication.R
import com.example.myapplication.SessionActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class ProfileFragment : Fragment(R.layout.fragment_profile) {


    lateinit var faqCardview : CardView
    lateinit var helpCardview : CardView
    lateinit var sessionCardview : CardView
    lateinit var logoutCardview : CardView
    lateinit var usernameTv : TextView
    lateinit var usernumberTv : TextView
    lateinit var editIv : ImageView
    lateinit var databaseReference: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        usernameTv = view.findViewById(R.id.tv_username)
        usernumberTv = view.findViewById(R.id.tv_usernumber)
        editIv = view.findViewById(R.id.iv_edit)

        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                usernameTv.text =  snapshot.child("1").child("username").getValue<String>()
                usernumberTv.text = snapshot.child("1").child("usernumber").getValue<String>()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )

        editIv.setOnClickListener {

               //     val modalBottomSheetDialog = ModelBottomSheetDialog()
             //       modalBottomSheetDialog.show(supportFragmentManager, ModelBottomSheetDialog.TAG)

        }

        faqCardview = view.findViewById(R.id.cd_faq)
        faqCardview.setOnClickListener {
            val intent = Intent(activity, FaqActivity::class.java)
            startActivity(intent)
        }


        sessionCardview = view.findViewById(R.id.cd_session)
        sessionCardview.setOnClickListener {
            val intent = Intent(activity, SessionActivity::class.java)
            startActivity(intent)
        }


        helpCardview = view.findViewById(R.id.cd_help)
        helpCardview.setOnClickListener {
            val intent = Intent(activity, HelpActivity::class.java)
            startActivity(intent)
        }

        logoutCardview = view.findViewById(R.id.cd_logout)
        logoutCardview.setOnClickListener {

        }


    }
}
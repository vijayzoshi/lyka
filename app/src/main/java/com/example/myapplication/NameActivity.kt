package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class NameActivity : AppCompatActivity() {



    private lateinit var databaseReference: DatabaseReference
  //  private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

     //   auth = Firebase.auth
    //    val userid = auth.currentUser?.uid.toString()
       //  databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userid)

        databaseReference = FirebaseDatabase.getInstance().getReference("users")



        val usernameTf = findViewById<TextInputLayout>(R.id.tf_username)
        val nextBtn = findViewById<Button>(R.id.btn_next)

        nextBtn.setOnClickListener {

            databaseReference.child("username").setValue(usernameTf.toString())
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }




    }
}
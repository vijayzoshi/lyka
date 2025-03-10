package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class OtpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
   // lateinit var storeverificationid : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        val nextBtn = findViewById<Button>(R.id.btn_next)
        val edittext = findViewById<EditText>(R.id.editTextText3)
        auth = Firebase.auth




       val storeverificationid = intent.getStringExtra("storedverificationid")
        nextBtn.setOnClickListener {
            verifyPhoneNumberWithCode(storeverificationid, edittext.text.toString() )
        }

    }

    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        signInWithPhoneAuthCredential(credential)
    }


    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(applicationContext, NameActivity :: class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "OTP verfication failed3", Toast.LENGTH_SHORT).show()
                }
            }
    }

}
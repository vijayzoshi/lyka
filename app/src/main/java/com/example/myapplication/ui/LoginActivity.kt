package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private var storedVerificationId: String? = ""
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val phonenumber = findViewById<TextInputLayout>(R.id.textField)
        val getotpBtn = findViewById<Button>(R.id.btn_getotp)

        auth = Firebase.auth

        // for checking whether user is already logged in or not
        if(auth.currentUser != null){
            val intent = Intent(this, MainActivity2 :: class.java)
            startActivity(intent)

        }

        getotpBtn.setOnClickListener {
            var number = phonenumber.editText?.text.toString().trim()
            if(number.length == 10) {
                number = "+91$number"
                startPhoneNumberVerification(number)
                val intent = Intent(applicationContext, OtpActivity::class.java)
                intent.putExtra("number", number)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Incorrect Phone Number", Toast.LENGTH_SHORT).show()
            }
        }


        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // verification got fail.
                Toast.makeText(applicationContext, "OTP verfication failed1", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken,
            ) {

                storedVerificationId = verificationId
                resendToken = token
                Toast.makeText(applicationContext, "OTP sent succesfully", Toast.LENGTH_SHORT).show()

                val intent = Intent(applicationContext, OtpActivity::class.java)
                intent.putExtra("storedverificationid", storedVerificationId)
                startActivity(intent)
                finish()
            }
        }

    }



    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = task.result?.user
                    val intent = Intent(applicationContext, NameActivity :: class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "OTP verfication failed2", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun startPhoneNumberVerification(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
          }

}

package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class NewActivity : AppCompatActivity() {


   // lateinit var videocallbtn : ZegoSendCallInvitationButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
/*
        var tv = findViewById<TextView>(R.id.textView)
        var targetuserId = findViewById<EditText>(R.id.editTextText)
         videocallbtn= findViewById(R.id.zegobutton)

        val userid = intent.getStringExtra("userid")
        tv.text = userid

        targetuserId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                startvideocall(targetuserId.text.toString())

            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        })
    }

     private fun startvideocall(targetuser : String) {

        videocallbtn.setIsVideoCall(true)
        videocallbtn.resourceID = "zego_uikit_call"
        videocallbtn.setInvitees(listOf(ZegoUIKitUser(targetuser)))
*/
    }
}
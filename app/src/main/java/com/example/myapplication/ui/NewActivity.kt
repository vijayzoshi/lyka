package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.R
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser
import java.util.Collections

class NewActivity : AppCompatActivity() {


    lateinit var videocallbtn : ZegoSendCallInvitationButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val tv = findViewById<TextView>(R.id.textView)
        val targetuserId = findViewById<EditText>(R.id.editTextText)
        val btn = findViewById<Button>(R.id.button0)
         videocallbtn= findViewById(R.id.zegobutton)

        val userid = intent.getStringExtra("userid")
        tv.text = userid


    //    startvideocall(targetuserId.text.toString().trim())


        startvideocall("hi")


        btn.setOnClickListener {

        }

       /*
        targetuserId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                startvideocall(targetuserId.text.toString().trim())

            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        })

        */
    }

     private fun startvideocall(targetuser : String) {

         videocallbtn.setIsVideoCall(true)

         videocallbtn.resourceID = "zego_uikit_call"
        videocallbtn.setInvitees(Collections.singletonList(ZegoUIKitUser(targetuser)))

    }
}
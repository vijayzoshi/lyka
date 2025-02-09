package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id = findViewById<EditText>(R.id.idet)
        val nextButton = findViewById<Button>(R.id.nextbtn)


        nextButton.setOnClickListener {

            startmyservice(id.text.toString())

            val intent = Intent(applicationContext, NewActivity :: class.java)
            intent.putExtra("userid", id.text.toString())
            startActivity(intent)


        }
    }


    fun startmyservice(userid : String){

        val application = application
        val appID : Long = 263932610
        val appSign = "e46b2599506137691249a65c4c0c01929c4424d1d2c9f9e89ce899e1c5348db2"
        val userID = userid
        val userName = userid

        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()

        ZegoUIKitPrebuiltCallService.init(
            application,
            appID,
            appSign,
            userID,
            userName,
            callInvitationConfig,
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        ZegoUIKitPrebuiltCallService.unInit()

    }
}
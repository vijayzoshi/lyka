package com.example.myapplication

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        var id = findViewById<EditText>(R.id.idet)
        var nextButton = findViewById<Button>(R.id.nextbtn)


        nextButton.setOnClickListener {

            startmyservice(id.text.toString())

            val intent = Intent(applicationContext, NewActivity :: class.java)
            intent.putExtra("userid", id.text.toString())
            startActivity(intent)

            val userid = id.text.toString()
            if(userid.isNotEmpty()){
                
            }
        }
    }


    fun startmyservice(userid : String){

        val application = application
        val appID : Long = 511199284
        val appSign = "1da15012d8f2ef221509945eb8f43fd901d775b9c1410cda6852e5d55a6d9c75"
        val userID = userid
        val userName = userid

        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()

        ZegoUIKitPrebuiltCallInvitationService.init(
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
        ZegoUIKitPrebuiltCallInvitationService.unInit()
*/
    }
}
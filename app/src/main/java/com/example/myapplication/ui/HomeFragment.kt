package com.example.myapplication.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.myapplication.adapter.TopExpertAdapter
import com.example.myapplication.model.TopExpertsModel
import com.example.myapplication.R
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.util.ArrayList




class HomeFragment : Fragment(R.layout.fragment_home) {


    //  lateinit var concernRecyclerview : RecyclerView
    //  lateinit var concernAdapter : ConcernAdapter
    //  lateinit var concernArraylist : ArrayList<ConcernModel>

    lateinit var expertRecyclerView: RecyclerView

    lateinit var expertAapter: TopExpertAdapter
    lateinit var expertArrayList: ArrayList<TopExpertsModel>
    lateinit var databaseRefrence: DatabaseReference
    lateinit var oneLv: LinearLayout
    lateinit var twoLv: LinearLayout
    lateinit var threeLv: LinearLayout
    lateinit var fourLv: LinearLayout
    lateinit var fiveLv: LinearLayout
    lateinit var sixLv: LinearLayout
    lateinit var sevenLv: LinearLayout
    lateinit var eightLv: LinearLayout
    lateinit var appointmentcl: ConstraintLayout
    lateinit var imageSlider : ImageSlider
    lateinit var homePi: CircularProgressIndicator
    lateinit var expertnameTv: TextView
    lateinit var sessiontimeTv: TextView
    lateinit var sessiondateTv: TextView
    lateinit var expertdesignTv: TextView
    lateinit var joinsessionBtn: Button



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val anxietyTv: TextView = view.findViewById(R.id.tv_anxiety)
        homePi = view.findViewById(R.id.pi_home)
        databaseRefrence = FirebaseDatabase.getInstance().getReference("users")
        appointmentcl = view.findViewById(R.id.cl)
        imageSlider = view.findViewById(R.id.image_slider)
        expertnameTv = view.findViewById(R.id.tv_expertname)
         sessiontimeTv = view.findViewById(R.id.tv_time)
         sessiondateTv  = view.findViewById(R.id.tv_date)
         expertdesignTv  = view.findViewById(R.id.tv_designation)
         joinsessionBtn  = view.findViewById(R.id.btn_joinsession)





        // Search
        val expertEt: EditText = view.findViewById(R.id.et_search)
        expertEt.setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }


        homePi.show()
        getnextsession();


        // Concerns
        oneLv = view.findViewById(R.id.lv_one)
        twoLv = view.findViewById(R.id.lv_two)
        threeLv = view.findViewById(R.id.lv_three)
        fourLv = view.findViewById(R.id.lv_four)
        fiveLv = view.findViewById(R.id.lv_five)
        sixLv = view.findViewById(R.id.lv_six)
        sevenLv = view.findViewById(R.id.lv_seven)
        eightLv = view.findViewById(R.id.lv_eight)

        navigate(oneLv, anxietyTv.text.toString())
        navigate(twoLv, anxietyTv.text.toString())
        navigate(threeLv, anxietyTv.text.toString())
        navigate(fourLv, anxietyTv.text.toString())
        navigate(fiveLv, anxietyTv.text.toString())
        navigate(sixLv, anxietyTv.text.toString())
        navigate(sevenLv, anxietyTv.text.toString())
        navigate(eightLv, anxietyTv.text.toString())

        val seeallBtn = view.findViewById<Button>(R.id.btn_visit)
        seeallBtn.setOnClickListener {
            val intent = Intent(activity, CategoriesActivity::class.java)
            startActivity(intent)
        }

        // Pass

        val cardView: CardView = view.findViewById(R.id.cd_pass)
        cardView.setOnClickListener {
            val intent = Intent(activity, SessionPassActivity::class.java)
            startActivity(intent)
        }


        // Seall

        val seeallTv = view.findViewById<TextView>(R.id.tv_seeall)
        seeallTv.setOnClickListener {
            val intent = Intent(activity, AllExpertsActivity::class.java)
            startActivity(intent)
        }

        // Recycler view


        expertArrayList = ArrayList<TopExpertsModel>()
        expertRecyclerView = view.findViewById(R.id.rv_experts)
        expertRecyclerView.layoutManager = LinearLayoutManager(context)

        databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")
        databaseRefrence.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (datasnapshot in snapshot.children) {
                        val data = datasnapshot.getValue(TopExpertsModel::class.java)
                        expertArrayList.add(data!!)
                    }
                    expertAapter = TopExpertAdapter(requireContext(), expertArrayList)
                    expertRecyclerView.adapter = expertAapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })


        /*    concernArraylist = ArrayList<ConcernModel>()
        concernArraylist.add(ConcernModel(R.drawable.usericon, "Anxiety"))
        concernArraylist.add(ConcernModel(R.drawable.usericon, "Anxiety"))
        concernArraylist.add(ConcernModel(R.drawable.usericon, "Anxiety"))
        concernArraylist.add(ConcernModel(R.drawable.usericon, "Anxiety"))
        concernArraylist.add(ConcernModel(R.drawable.usericon, "Anxiety"))
*/
        /*
                concernAdapter = ConcernAdapter(concernArraylist)

                concernRecyclerview = view.findViewById(R.id.rv_concern)
                concernRecyclerview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                concernRecyclerview.adapter = concernAdapter

        */

    }

    private fun getnextsession() {
        databaseRefrence.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                homePi.hide()


                val issessionbooked =
                    snapshot.child("1").child("nextsession").child("isbooked").getValue<Boolean>()!!

                if (issessionbooked) {
                    // Upcomingsession

                    //   val expertpicIv : ImageView = view.findViewById(R.id.iv_expertpic)
                    appointmentcl.visibility = View.VISIBLE

                    expertnameTv.text =
                        snapshot.child("1").child("nextsession").child("nextsessiondetails")
                            .child("expertname").getValue<String>()
                    sessiondateTv.text =
                        snapshot.child("1").child("nextsession").child("nextsessiondetails")
                            .child("sessiondate").getValue<String>()
                    sessiontimeTv.text =
                        snapshot.child("1").child("nextsession").child("nextsessiondetails")
                            .child("sessiontime").getValue<String>()
                    expertdesignTv.text =
                        snapshot.child("1").child("nextsession").child("nextsessiondetails")
                            .child("expertdesign").getValue<String>()

                    val isonlineSession =
                        snapshot.child("1").child("nextsession").child("nextsessiondetails")
                            .child("isonlinesession").getValue<Boolean>()!!

                    if (isonlineSession) {
                        joinsessionBtn.text = "Join Session"
                        joinsessionBtn.setOnClickListener {
                            // startmyservice("***********")
                            val intent = Intent(activity, NewActivity::class.java)
                            startActivity(intent)
                        }
                    } else {


                        val lat =
                            snapshot.child("1").child("nextsession").child("nextsessiondetails")
                                .child("cliniclat").getValue<String>()
                        val long =
                            snapshot.child("1").child("nextsession").child("nextsessiondetails")
                                .child("cliniclong").getValue<String>()



                        joinsessionBtn.text = "Clinic Address"
                        joinsessionBtn.setOnClickListener {

                            // Create the Uri for the location
                        //    val gmmIntentUri = Uri.parse("geo:28.6129,77.2295")
                            val gmmIntentUri = Uri.parse("geo:$lat,$long")

                            // Create the implicit Intent
                            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

                            // Set the package to ensure it opens in Google Maps
                            mapIntent.setPackage("com.google.android.apps.maps")
                            startActivity(mapIntent)

                        }
                    }

                } else {

                    // imageslider
                    imageSlider.visibility = View.VISIBLE
                    val imageList = ArrayList<SlideModel>()
                    // imageList.add(SlideModel("String Url" or R.drawable) imageList.add(SlideModel("String Url" or R.drawable, "title")
                    imageList.add(SlideModel("https://bit.ly/2YoJ77H"))
                    imageList.add(SlideModel("https://bit.ly/2BteuF2"))
                    imageList.add(SlideModel("https://bit.ly/3fLJf72"))
                    imageSlider.setImageList(imageList)
                    appointmentcl.visibility = View.GONE
                }



            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        }



        )


    }

    fun navigate(ll: LinearLayout, concerntype: String) {
        ll.setOnClickListener {
            val intent = Intent(context, CategoriesActivity::class.java)
            intent.putExtra("concerntype", concerntype)
            startActivity(intent)
        }
    }

    /*
    fun startmyservice(userid : String){

        val application = activity // doubt
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

     */

}
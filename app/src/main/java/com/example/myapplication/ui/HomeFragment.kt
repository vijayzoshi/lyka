package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.myapplication.adapter.TopExpertAdapter
import com.example.myapplication.CategoriesActivity
import com.example.myapplication.model.TopExpertsModel
import com.example.myapplication.R
import com.example.myapplication.SearchActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList


class HomeFragment : Fragment(R.layout.fragment_home) {

  //  lateinit var concernRecyclerview : RecyclerView
  //  lateinit var concernAdapter : ConcernAdapter
  //  lateinit var concernArraylist : ArrayList<ConcernModel>

    lateinit var expertRecyclerView : RecyclerView
    lateinit var expertAapter : TopExpertAdapter
    lateinit var expertArrayList : ArrayList<TopExpertsModel>
    lateinit var databaseRefrence : DatabaseReference
    lateinit var oneLv : LinearLayout
    lateinit var twoLv : LinearLayout
    lateinit var threeLv : LinearLayout
    lateinit var fourLv : LinearLayout
    lateinit var fiveLv : LinearLayout
    lateinit var sixLv : LinearLayout
    lateinit var sevenLv : LinearLayout
    lateinit var eightLv : LinearLayout
    lateinit var expertSv : SearchView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        expertSv = view.findViewById(R.id.sv_experts)
        expertSv.setOnClickListener {
            val intent = Intent(context, SearchActivity :: class.java)
            startActivity(intent)

        }

        oneLv = view.findViewById(R.id.lv_one)
        twoLv = view.findViewById(R.id.lv_two)
        threeLv = view.findViewById(R.id.lv_three)
        fourLv = view.findViewById(R.id.lv_four)
        fiveLv = view.findViewById(R.id.lv_five)
        sixLv = view.findViewById(R.id.lv_six)
        sevenLv = view.findViewById(R.id.lv_seven)
        eightLv = view.findViewById(R.id.lv_eight)

        navigate(oneLv)
        navigate(twoLv)
        navigate(threeLv)
        navigate(fourLv)
        navigate(fiveLv)
        navigate(sixLv)
        navigate(sevenLv)
        navigate(eightLv)

        val seeallTv = view.findViewById<TextView>(R.id.tv_seeall)
        seeallTv.setOnClickListener {
            val intent = Intent(context, CategoriesActivity :: class.java)
            startActivity(intent)
        }

        val imageList = ArrayList<SlideModel>() // Create image list
// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title
        imageList.add(SlideModel("https://bit.ly/2YoJ77H"))
        imageList.add(SlideModel("https://bit.ly/2BteuF2"))
        imageList.add(SlideModel("https://bit.ly/3fLJf72"))
        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
        imageSlider.visibility = View.GONE


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
        expertArrayList = ArrayList<TopExpertsModel>()
        expertRecyclerView = view.findViewById(R.id.rv_experts)
        expertRecyclerView.layoutManager = LinearLayoutManager(context)

        databaseRefrence = FirebaseDatabase.getInstance().getReference("experts")
        databaseRefrence.addValueEventListener( object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for(datasnapshot in snapshot.children){
                        val data = datasnapshot.getValue(TopExpertsModel :: class.java)
                        expertArrayList.add(data!!)
                    }
                    expertAapter = TopExpertAdapter(expertArrayList)
                    expertRecyclerView.adapter = expertAapter
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        } )

    }

    fun navigate(ll : LinearLayout){
        ll.setOnClickListener {
            val intent = Intent(context, CategoriesActivity :: class.java)
            startActivity(intent)
        }
    }

}
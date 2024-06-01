package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.CategoriesAdapter
import com.example.myapplication.model.CategoriesModel

class CategoriesActivity : AppCompatActivity() {


     lateinit var categoriesRecyclerview : RecyclerView
     lateinit var categoriesAdapter : CategoriesAdapter
     lateinit var categoriesArraylist : ArrayList<CategoriesModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
          categoriesArraylist = ArrayList<CategoriesModel>()
/*
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))

        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))

        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))

        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))

        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))

        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))

        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))

        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))
        categoriesArraylist.add(  CategoriesModel(R.drawable.usericon, "Anxiety"))

*/








         categoriesArraylist.add(  CategoriesModel(R.drawable.anxiety, "Anxiety"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.adhd, "ADHD"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.bipolar, "Bipolar"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.love, "LGBTQ"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.loneliness, "Loneliness"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.ocd, "OCD"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.relationships, "Relationships"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.sleep, "Sleep Issue"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.depression, "Trauma"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.overthinking, "Overthinking"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.schizophrenia, "Scizophrenia"))
         categoriesArraylist.add(  CategoriesModel(R.drawable.student, "Child Specialist"))



        categoriesAdapter = CategoriesAdapter(this,categoriesArraylist)

                categoriesRecyclerview = findViewById(R.id.rv_categories)
                categoriesRecyclerview.layoutManager =  GridLayoutManager(this,2)
                categoriesRecyclerview.adapter = categoriesAdapter






    }
}
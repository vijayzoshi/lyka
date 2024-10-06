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


                categoriesAdapter = CategoriesAdapter(categoriesArraylist)

                categoriesRecyclerview = findViewById(R.id.rv_categories)
                categoriesRecyclerview.layoutManager =  GridLayoutManager(this,2)
                categoriesRecyclerview.adapter = categoriesAdapter






    }
}
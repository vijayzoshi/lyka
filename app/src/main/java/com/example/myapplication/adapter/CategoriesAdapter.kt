package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.CategoriesModel
import com.example.myapplication.R

class CategoriesAdapter(var datalist: ArrayList<CategoriesModel>) : RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.rv_categories, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return datalist.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

      //  holder.categoriesPic.setImageResource(datalist.get(position).categoriespic)
        holder.categoriesName.text = datalist[position].categoriesname
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

     //   val categoriesPic = view.findViewById<ImageView>(R.id.iv_concernicon)
        val categoriesName = view.findViewById<TextView>(R.id.tv_concernname)


    }
}
package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.ExpertprofileActivity
import com.example.myapplication.model.TopExpertsModel
import com.example.myapplication.R

class TopExpertAdapter(val context: Context, var datalist : ArrayList<TopExpertsModel>) : RecyclerView.Adapter<TopExpertAdapter.MyViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_experts, parent, false)
        return MyViewHolder(view)

    }


    

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun searchDataList(searchList: ArrayList<TopExpertsModel>) {
        datalist = searchList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.expertname.text = datalist.get(position).expertname

        holder.expertdesign.text = datalist.get(position).expertdesign

        val exp = datalist.get(position).expertexp.toString() + " years"
        holder.expertexp.text = exp

        holder.expertrating.text = datalist.get(position).expertrating.toString()

        val charge =  "Rs." + datalist.get(position).expertcharge.toString()
        holder.expertcharge.text = charge

      //  holder.expertpic.setImageResource(datalist.get(position).expertpic)

        val expertid = datalist.get(position).expertid

        holder.booknow.setOnClickListener {
            val intent = Intent(context, ExpertprofileActivity:: class.java)
            intent.putExtra("expertid", expertid)
            context.startActivity(intent)
        }


    }


    class MyViewHolder(itemview : View ) : RecyclerView.ViewHolder(itemview){
        val expertname = itemview.findViewById<TextView>(R.id.tv_expertname)
        val expertdesign = itemview.findViewById<TextView>(R.id.tv_designation)
        val expertexp = itemview.findViewById<TextView>(R.id.tv_experince)
        val expertrating = itemview.findViewById<TextView>(R.id.tv_ratings)
        val expertcharge = itemview.findViewById<TextView>(R.id.tv_charge)
        val booknow = itemview.findViewById<Button>(R.id.btn_booknow)
       // val expertpic = itemview.findViewById<ImageView>(R.id.iv_expertpic)
    }
}
package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.AllChatsmodel
import com.example.myapplication.PersonalchatActivity
import com.example.myapplication.R
import java.util.ArrayList

class AllchatsAdapter(val context: Context, var datalist: ArrayList<AllChatsmodel>) : RecyclerView.Adapter<AllchatsAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_allchats, parent, false)
        return AllchatsAdapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.expertChatname.text = datalist.get(position).expertchatname
        holder.expertChatpic.setImageResource(datalist.get(position).expertchatpic)
        holder.expertLastmsg.text = datalist.get(position).exprtlastmsg

        val contextnew = holder.itemView.context
        holder.itemView.setOnClickListener {
            val intent = Intent(context, PersonalchatActivity :: class.java)
            context.startActivity(intent)
        }
    }


    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

        val expertChatname = itemview.findViewById<TextView>(R.id.tv_expertchatname)
        val expertLastmsg = itemview.findViewById<TextView>(R.id.tv_expertlastmsg)
        val expertChatpic = itemview.findViewById<ImageView>(R.id.iv_expertchatpic)
    }

}
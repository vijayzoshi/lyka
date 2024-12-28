package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.PersonalchatsModel
import com.google.firebase.auth.FirebaseAuth

class PersonalchatsAdapter() {



    class PersonalchatsAdapter(var context: Context, var datalist: ArrayList<PersonalchatsModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        var ITEM_SENT = 1
        var ITEM_RECEIVE = 2

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return if(viewType == ITEM_SENT){

                SentViewholder(  LayoutInflater.from(parent.context).inflate(R.layout.rv_sentmsg, parent, false))
            }else{
                ReceiveViewholder(  LayoutInflater.from(parent.context).inflate(R.layout.rv_receivemsg, parent, false))
            }

        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


            if(holder.itemViewType == ITEM_SENT){

                val viewHolder = holder as SentViewholder
                holder.sendMsg.text = datalist.get(position).sendmsg
                holder.sendTime.text = datalist.get(position).sendtime

            }else{
                val viewHolder = holder as ReceiveViewholder
                holder.recieveMsg.text = datalist.get(position).sendmsg
                holder.receiveTime.text = datalist.get(position).sendtime
            }


        }

        override fun getItemCount(): Int {
            return datalist.size
        }

        override fun getItemViewType(position: Int): Int {
            return if( FirebaseAuth.getInstance().uid.toString() == datalist.get(position).senderid
            ){
                ITEM_SENT
            }else{
                ITEM_RECEIVE
            }


        }

       inner  class SentViewholder(itemview: View) : RecyclerView.ViewHolder(itemview) {

            val sendMsg = itemview.findViewById<TextView>(R.id.tv_receivemsg)
            val sendTime = itemview.findViewById<TextView>(R.id.tv_receivetime)
        }

       inner  class ReceiveViewholder(itemview: View) : RecyclerView.ViewHolder(itemview) {
            val recieveMsg = itemview.findViewById<TextView>(R.id.tv_receivemsg)
            val receiveTime = itemview.findViewById<TextView>(R.id.tv_receivetime)
        }

    }


}


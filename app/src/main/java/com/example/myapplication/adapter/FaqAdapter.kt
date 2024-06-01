package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.FaqModel
import com.example.myapplication.R

class FaqAdapter(  val datalist : ArrayList<FaqModel>) : RecyclerView.Adapter<FaqAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_faq, parent, false)
        return MyViewHolder(view) }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ans.text = datalist[position].ans
        holder.ques.text = datalist[position].ques


        val isExpandable = datalist[position].isexpandable
        if(isExpandable){
            holder.ans.visibility = View.VISIBLE

        }else{
            holder.ans.visibility = View.GONE

        }

          holder.itemView.setOnClickListener {
              datalist[position].isexpandable = !datalist[position].isexpandable
              notifyItemChanged(position)
        }
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val ques  = itemview.findViewById<TextView>(R.id.tv_ques)
        val ans = itemview.findViewById<TextView>(R.id.tv_ans)
    }
}


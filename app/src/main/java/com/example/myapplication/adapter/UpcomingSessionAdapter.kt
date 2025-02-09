package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.UpcomingSessionModel
import com.example.myapplication.R
import com.example.myapplication.ui.SessionDetailsActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class UpcomingSessionAdapter( val context: Context, var datalist: ArrayList<UpcomingSessionModel>) : RecyclerView.Adapter<UpcomingSessionAdapter.MyViewHolder>() {



    lateinit var databaseRefrence : DatabaseReference
    lateinit var snackbar: Snackbar



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_upcomingsession, parent, false)
        return UpcomingSessionAdapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        databaseRefrence = FirebaseDatabase.getInstance().getReference("users").child("1").child("sessions").child("upcomingsessions")



        holder.expertName.text = datalist.get(position).expertname
    //   holder.expertPic.setImageResource(datalist.get(position).experpic)
     /*   holder.expertDesig.text = datalist.get(position).expertdesig
        holder.sessionDate.text = datalist.get(position).sessiondate
        holder.sessionTime.text = datalist.get(position).sessiontime

      */

        val ss = datalist.get(position).sessionid.toString()


        holder.cancel.setOnClickListener {



            MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(R.string.cancel_this_session))
                .setNegativeButton("No") { dialog, which ->
                    dialog.cancel()
                }
                .setPositiveButton("Yes") { dialog, which ->

                    databaseRefrence.child("1").removeValue()
                    notifyItemChanged(position)


                    snackbar =  Snackbar.make(it, "Session Deleted", Snackbar.LENGTH_LONG)
                    snackbar.setAction("Ok") {

                            // Responds to click on the action
                            snackbar.dismiss()

                        }
                        .show()


                }
                .show()


        }

        holder.viewDetails.setOnClickListener {
            val intent = Intent(context, SessionDetailsActivity:: class.java)
            context.startActivity(intent)
        }







    }


    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

        val expertName = itemview.findViewById<TextView>(R.id.tv_expertname)
        //val expertPic = itemview.findViewById<ImageView>(R.id.iv_expertpic)

/*
        val expertDesig = itemview.findViewById<TextView>(R.id.tv_expertdesig)
        val sessionDate = itemview.findViewById<TextView>(R.id.tv_sessiondate)
        val sessionTime = itemview.findViewById<TextView>(R.id.tv_sessiontime)
        */

        val cancel = itemview.findViewById<Button>(R.id.btn_cancel)
        val viewDetails = itemview.findViewById<Button>(R.id.btn_viewdetails)


    }

}
package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class BttomSheetName : BottomSheetDialogFragment() {


    lateinit var databaseRefrence: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_bttom_sheet_name, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        databaseRefrence = FirebaseDatabase.getInstance().getReference("users")
        val usernameTf = view.findViewById<TextInputLayout>(R.id.tf_username)



        val confirmBtn = view.findViewById<Button>(R.id.btn_confirm)
        confirmBtn.setOnClickListener {


            databaseRefrence.child("1").child("username").setValue(usernameTf.editText?.text.toString())

            dismiss()
        }

    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}
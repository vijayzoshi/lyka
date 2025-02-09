package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModelBottomSheetDialog : BottomSheetDialogFragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.bottomsheet_info, container, false)



    val abc = AllExpertsActivity()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val okayBtn = view.findViewById<Button>(R.id.button3)
        okayBtn.setOnClickListener {


            abc.filter("psychologist")
            dismiss()
        }

    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

}
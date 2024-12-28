package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.model.TopExpertsModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import java.util.ArrayList
import java.util.Locale

class ModelBottomSheetDialog : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.bottomsheet_info, container, false)

    val usernameTv = view?.findViewById<TextInputLayout>(R.id.tf_username)
    







    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val okayBtn = view.findViewById<Button>(R.id.button3)
okayBtn.setOnClickListener { dismiss() }

    }






    companion object {
        const val TAG = "ModalBottomSheet"
    }

}
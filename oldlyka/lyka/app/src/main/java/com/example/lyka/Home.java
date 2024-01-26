package com.example.lyka;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends Fragment{


    TextView catviewAll;
  //  initialised arraylist
    ArrayList<diseasemodel> arraydisease = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_home, container, false);

       catviewAll = view.findViewById(R.id.catviewall);
      // catviewAll.setOnClickListener(();
        RecyclerView recyclerView = view.findViewById(R.id.diseaseRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));



        arraydisease.add()










        return view;
    }
}
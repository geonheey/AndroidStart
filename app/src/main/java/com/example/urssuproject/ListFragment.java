package com.example.urssuproject;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ListFragment extends Fragment {
    private DatabaseReference mDatabase;
    private RecyclerView recyclerView;

    private View view;

    private TextView tv_name, tv_num;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        tv_name = v.findViewById(R.id.tv_Name);
        tv_num = v.findViewById(R.id.tv_Number);



        if(getArguments() != null){

            String param1 = getArguments().getString("NAME"); // 전달한 key 값
            String param2 = getArguments().getString("NUMBER"); // 전달한 key 값
            tv_name.setText(param1);
            tv_num.setText(param2);

        }
        return v;

    }


}

package com.example.urssuproject;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private String name,number;
    private TextView tv_name, tv_num;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_list,container,false);
        tv_num = viewGroup.findViewById(R.id.tv_number);

        //RequestActivity에서 전달한 번들 저장
        Bundle bundle = getArguments();

        //번들 안의 텍스트 불러오기
        String text = bundle.getString("text");

        //fragment1의 TextView에 전달 받은 text 띄우기
        tv_num.setText(text);

        return viewGroup;

    }
}

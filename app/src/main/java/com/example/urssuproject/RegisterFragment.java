package com.example.urssuproject;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterFragment extends Fragment {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();


    private DatabaseReference databaseReference = database.getReference();
    private Button mSave;
    private EditText mName, mNumber;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_register, container, false);

        mSave = v.findViewById(R.id.register);
        mName = v.findViewById(R.id.editName);
        mNumber = v.findViewById(R.id.editPhone);



        mSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String strName = mName.getText().toString();
                String strNumber = mNumber.getText().toString();

                if(strName.length() > 0 && strNumber.length() > 0){
                    Toast.makeText(getActivity(), "등록되었습니다.", Toast.LENGTH_SHORT).show();
                    RegisterFragment fragment1 = new RegisterFragment(); // Fragment 생성
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Bundle bundle = new Bundle();
                    bundle.putString("NAME", mName.getText().toString()); // Key, Value
                    bundle.putString("NUMBER", mNumber.getText().toString()); // Key, Value
                    ListFragment fragment2 = new ListFragment();
                    //FragmentTransaction transaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                    fragment2.setArguments(bundle);
                    transaction.replace(R.id.containers, fragment2);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    //fragment1.setArguments(bundle);
                }else{
                    Toast.makeText(getActivity(), "등록 실패하였습니다.", Toast.LENGTH_SHORT).show();
                }




            }
        });
        return v;
    }


}
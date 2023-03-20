package com.example.urssuproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;


public class RegisterFragment extends Fragment {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private DatabaseReference databaseReference = database.getReference();
    private Button mSave;
    private EditText mName, mNumber;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Contact");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_register, container, false);

        mSave = v.findViewById(R.id.register);
        mName = v.findViewById(R.id.editName);
        mNumber = v.findViewById(R.id.editPhone);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strname = mName.getText().toString();
                String strnum = mNumber.getText().toString();

                HashMap<String, String> map = new HashMap<>();
                map.put("name",strname);
                map.put("number", strnum);



                if(strname.length()> 0 && strnum.length() > 0 ) {
                    Toast.makeText(getActivity(), "등록되었습니다.", Toast.LENGTH_SHORT).show();
                    inputInfo(strname, strnum);
                } else{
                    Toast.makeText(getActivity(), "등록실패하였습니다.", Toast.LENGTH_SHORT).show();

                }

            }
            public void inputInfo(String iname, String inum){
                Information nInfo = new Information(iname, inum);
                ref.push().setValue(nInfo);
            }
        });
        return v;
    }
}
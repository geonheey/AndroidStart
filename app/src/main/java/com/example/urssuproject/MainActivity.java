package com.example.urssuproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationBarView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RegisterFragment registerFragment;
    ListFragment listFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        registerFragment = new RegisterFragment();
        listFragment = new ListFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        RegisterFragment registerFragment = new RegisterFragment();
        transaction.replace(R.id.containers, registerFragment);
        transaction.commit();


        getSupportFragmentManager().beginTransaction().replace(R.id.containers, registerFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.reginavi:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, registerFragment).commit();
                        return true;
                    case R.id.list:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, listFragment).commit();
                        return true;

                }
                return false;
            }

        });

    }

}

package com.example.urssuproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    RegisterFragment registerFragment;
    ListFragment listFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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

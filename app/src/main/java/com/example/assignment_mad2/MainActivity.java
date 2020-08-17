package com.example.assignment_mad2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
loadFragment();

    }
private void loadFragment(){
    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.mainfragment,new registerdetails());
    ft.commit();
}

}
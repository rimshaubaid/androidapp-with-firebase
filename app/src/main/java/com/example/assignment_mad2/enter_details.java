package com.example.assignment_mad2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class enter_details extends Fragment {
        EditText email;
        EditText password_;
        Button login;
        Button register;
        View view;
        Button viewdetails;
        details d;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_enter_details, container, false);
         email=view.findViewById(R.id.editTextTextPersonName3);
        password_=view.findViewById(R.id.editTextTextPassword);
        login=view.findViewById(R.id.button);
        viewdetails=view.findViewById(R.id.button4);
        register=view.findViewById(R.id.button2);

       login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=d.getName();
                String username2=email.getText().toString();
                String password=d.getPass();
                String password1=password_.getText().toString();
                if(username==username2 && password==password1){
                    loadFragment2();
                }else
                   Toast.makeText(getContext(),"Wrong username or password",Toast.LENGTH_LONG).show();
            }
        });
    register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment();

            }
        });
viewdetails.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        loadFragment2();
    }
});
        return view;
    }

private void loadFragment(){
    FragmentManager fm=getFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.mainfragment,new registerdetails());
    ft.addToBackStack(null);
    ft.commit();
}

private void loadFragment2(){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.mainfragment,new viewdetails());
        ft.addToBackStack(null);
        ft.commit();
}


}
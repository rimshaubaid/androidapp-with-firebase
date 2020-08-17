package com.example.assignment_mad2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerdetails extends Fragment {
View view;
EditText name;
EditText age;
RadioButton male;
RadioButton female;
AutoCompleteTextView hobbies;
EditText dob;
Button add;
Button viewdetails;
EditText password;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

     view=inflater.inflate(R.layout.fragment_registerdetails, container, false);
    name=view.findViewById(R.id.editTextTextPersonName);
     age=view.findViewById(R.id.editTextNumber);
     male=view.findViewById(R.id.radioButton);
     female=view.findViewById(R.id.radioButton2);
     hobbies=view.findViewById(R.id.autoCompleteTextView);
     dob=view.findViewById(R.id.editTextDate);
     add=view.findViewById(R.id.button3);
    password=view.findViewById(R.id.editTextTextPassword);
     viewdetails=view.findViewById(R.id.button5);
     add.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Toast.makeText(getContext(),"USER ADDED",Toast.LENGTH_LONG).show();
             addData();
         }
     });
     viewdetails.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             loadFragment();
         }
     });
     return view;
    }

private void loadFragment(){
    FragmentManager fm=getFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.mainfragment,new viewdetails());
    ft.addToBackStack(null);
    ft.commit();
}

public void addData(){
    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    DatabaseReference reference = rootNode.getReference("Users");
    String userName=name.getText().toString();
    String userAge=age.getText().toString();
    String userGender;
   if(male.isChecked()){
     userGender=male.getText().toString();
   }else {
      userGender = female.getText().toString();
   }
   String userHobby=hobbies.getText().toString();
   String userDob=dob.getText().toString();
//String userpass=password.getText().toString();
    String id = reference.push().getKey();
    details d=new details(id,userName,userAge,userGender,userHobby,userDob);

    reference.child(id).setValue(d);
    Toast.makeText(getContext(),"Task Added Successfully",Toast.LENGTH_LONG).show();
}
}
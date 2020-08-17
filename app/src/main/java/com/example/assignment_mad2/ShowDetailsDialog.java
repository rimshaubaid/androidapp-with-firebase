package com.example.assignment_mad2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowDetailsDialog extends Fragment {
    private details d;
    private EditText name, age, gender, hobbies, dob;
    private Button ok;
   View view;


    @NonNull
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                 Bundle savedInstanceState){
        view=inflater.inflate(R.layout.fragment_dialog, container, false);

        name=view.findViewById(R.id.editTextTextPersonName);
        age=view.findViewById(R.id.editTextNumber);
        gender=view.findViewById(R.id.editTextTextPersonName2);
        hobbies=view.findViewById(R.id.autoCompleteTextView);
        dob=view.findViewById(R.id.editTextDate);

        name.setText(d.getName());
        age.setText(d.getAge());
        gender.setText(d.getGender());
        hobbies.setText(d.getHobby());
        dob.setText(d.getDob());
ok.setOnClickListener(new View.OnClickListener() {
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
}
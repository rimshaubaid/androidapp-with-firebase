package com.example.assignment_mad2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class viewdetails extends Fragment {

    private RecyclerView recyclerView;
    View view;
    private details_adapter adapter;
    DatabaseReference reference;
    private List<details> userList = new ArrayList<>();
details d;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_viewdetails, container, false);
        reference = FirebaseDatabase.getInstance().getReference("Users");
        recyclerView = view.findViewById(R.id.recycler_view);

        adapter = new details_adapter(getContext(), userList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 6));
        recyclerView.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    details d = postSnapshot.getValue(details.class);
                    userList.add(d);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                details d=userList.get(position);
               loadFragment();

            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));
        return view;
    }

private void loadFragment(){
    FragmentManager fm=getFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.mainfragment,new ShowDetailsDialog());
    ft.addToBackStack(null);
    ft.commit();
}

}
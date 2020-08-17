package com.example.assignment_mad2;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class details_adapter extends RecyclerView.Adapter<details_adapter.MyViewHolder> {
    private Context context;
    private List<details> detailsList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView name;

    public MyViewHolder(View v){
    super(v);
    name=v.findViewById(R.id.textView);
    }

    }

    public details_adapter(Context context,List<details> userList){
    this.context=context;
    this.detailsList=userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.details_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            details user = detailsList.get(position);
            holder.name.setText(user.getName());

    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }
}

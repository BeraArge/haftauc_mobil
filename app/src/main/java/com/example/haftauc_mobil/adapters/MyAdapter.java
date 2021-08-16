package com.example.haftauc_mobil.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.haftauc_mobil.R;
import com.example.haftauc_mobil.models.DataModel;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<DataModel> list;

    public MyAdapter(ArrayList<DataModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userId.setText(Integer.toString(list.get(position).getId()));
        holder.name.setText(list.get(position).getName());
        holder.surname.setText(list.get(position).getSurname());
        holder.year.setText(list.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, surname, year, userId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            name = itemView.findViewById(R.id.name);
            surname = itemView.findViewById(R.id.surname);
            year = itemView.findViewById(R.id.year);
        }
    }

}

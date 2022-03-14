package com.example.fitvita20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context, ArrayList<Model> mList){
        this.mList = mList;
        this.context = context;
    }

    public void setList(ArrayList<Model> newList){
        this.mList = newList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false );
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Model model = mList.get(position);

            holder.name.setText(model.getFood_name());
            holder.carbs.setText(model.getCarbs());
            holder.calories.setText(model.getCalorii());
            holder.serving.setText(model.getGramaj());
            holder.protein.setText(model.getProteine());
            holder.fat.setText(model.getFat());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, serving, calories, protein, carbs, fat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            serving = itemView.findViewById(R.id.serving);
            calories = itemView.findViewById(R.id.calories);
            protein = itemView.findViewById(R.id.protein);
            carbs = itemView.findViewById(R.id.carbs);
            fat = itemView.findViewById(R.id.fat);
        }
    }
}

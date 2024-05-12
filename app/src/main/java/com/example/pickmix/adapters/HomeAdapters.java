package com.example.pickmix.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pickmix.R;
import com.example.pickmix.models.HomeCtegory;

import java.util.List;

public class HomeAdapters extends RecyclerView.Adapter<HomeAdapters.Viewholder> {

    Context context;
    List<HomeCtegory>categoryList;

    public HomeAdapters(Context context, List<HomeCtegory> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cat_items,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Glide.with(context).load(categoryList.get(position).getImg_url()).into(holder.catImg);
        holder.name.setText(categoryList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView catImg;
        TextView name;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            catImg=itemView.findViewById(R.id.home_cat_img);
            name=itemView.findViewById(R.id.cat_home_name);

        }
    }
}

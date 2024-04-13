package com.example.jewelleryapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Context context;
    ArrayList<HomeItemModel> arrCategoryItem;
    CategoryAdapter(Context context,ArrayList<HomeItemModel> arrCategoryItem){
        this.context=context;
        this.arrCategoryItem=arrCategoryItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category_items,parent,false);
        CategoryAdapter.ViewHolder viewHolder = new CategoryAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.item_img.setImageResource(arrCategoryItem.get(position).img);
        holder.item_name.setText(arrCategoryItem.get(position).name);

    }

    @Override
    public int getItemCount() {
        return arrCategoryItem.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_name;
        ImageView item_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.category_items_img_id);
            item_name = itemView.findViewById(R.id.category_items_name_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            Intent i = new Intent(context,MainActivity3.class);
            i.putExtra("category_item_id",pos);
            context.startActivity(i);
        }
    }
}
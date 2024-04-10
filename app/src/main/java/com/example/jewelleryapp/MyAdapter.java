package com.example.jewelleryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<HomeItemModel> arrHomeItem;
    MyAdapter(Context context, ArrayList<HomeItemModel> arrayList){
        this.context=context;
        this.arrHomeItem=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_home,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item_img.setImageResource(arrHomeItem.get(position).img);
        holder.item_name.setText(arrHomeItem.get(position).name);
        holder.item_price.setText(arrHomeItem.get(position).price);
    }

    @Override
    public int getItemCount() {
        return arrHomeItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_name,item_price;
        ImageView item_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_image_id);
            item_name = itemView.findViewById(R.id.item_name_id);
            item_price = itemView.findViewById(R.id.item_price_id);
        }
    }
}

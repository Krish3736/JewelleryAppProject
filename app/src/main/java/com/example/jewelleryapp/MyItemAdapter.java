package com.example.jewelleryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;
import com.example.jewelleryapp.MyItemAdapter.OnItemClickListener;
import java.util.ArrayList;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.ViewHolder> {
    Context context;
    ArrayList<HomeItemModel> arrHomeItem;
    OnItemClickListener listener;
    MyItemAdapter(Context context, ArrayList<HomeItemModel> arrayList,OnItemClickListener listener){
        this.context=context;
        this.arrHomeItem=arrayList;
        this.listener=listener;
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
        final HomeItemModel item = arrHomeItem.get(position);
        holder.item_img.setImageResource(arrHomeItem.get(position).img);
        holder.item_name.setText(arrHomeItem.get(position).name);
        holder.item_price.setText(arrHomeItem.get(position).price);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(item);
            }
        });
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

    public interface OnItemClickListener {
        void onItemClick(HomeItemModel item);
    }
}

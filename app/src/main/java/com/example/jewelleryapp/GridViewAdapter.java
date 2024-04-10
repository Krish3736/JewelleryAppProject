package com.example.jewelleryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GridViewAdapter extends ArrayAdapter<HomeItemModel> {

    Context gridViewContext;
    int gridViewResource;
    ArrayList<HomeItemModel> gridHomeItemModels;

    public GridViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<HomeItemModel> objects) {
        super(context, resource, objects);
        this.gridViewContext=context;
        this.gridViewResource=resource;
        this.gridHomeItemModels=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(gridViewContext);
            convertView = inflater.inflate(gridViewResource, parent, false);
        }

        ImageView item_img = convertView.findViewById(R.id.item_image_id);
        TextView item_name = convertView.findViewById(R.id.item_name_id);
        TextView item_price = convertView.findViewById(R.id.item_price_id);


        HomeItemModel currentItem = getItem(position);

        if (currentItem != null) {
            item_img.setImageResource(currentItem.img);
            item_name.setText(currentItem.name);
            item_price.setText(currentItem.price);
        }

        return convertView;
    }
}

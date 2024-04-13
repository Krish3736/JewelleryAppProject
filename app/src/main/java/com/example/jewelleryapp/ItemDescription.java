package com.example.jewelleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jewelleryapp.databinding.ActivityItemDescriptionBinding;
import com.example.jewelleryapp.databinding.ActivityMain3Binding;

public class ItemDescription extends AppCompatActivity {
    ActivityItemDescriptionBinding activityItemDescriptionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        activityItemDescriptionBinding = ActivityItemDescriptionBinding.inflate(getLayoutInflater());
        setContentView(activityItemDescriptionBinding.getRoot());

        Intent i = getIntent();
        int item_img = i.getIntExtra("item_image",0);
        String item_name = i.getStringExtra("item_name");
        String item_price=i.getStringExtra("item_price");

        activityItemDescriptionBinding.idFragmentItemDescriptionImage.setImageResource(item_img);
        activityItemDescriptionBinding.idItemDescriptionText1.setText(item_name);
        activityItemDescriptionBinding.idItemDescriptionText2.setText(item_price);
    }
}
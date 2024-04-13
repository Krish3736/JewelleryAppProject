package com.example.jewelleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jewelleryapp.databinding.ActivityItemDescriptionBinding;

public class ItemDescription extends AppCompatActivity {
    ActivityItemDescriptionBinding activityItemDescriptionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);
    }
}
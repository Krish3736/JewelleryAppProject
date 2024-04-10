package com.example.jewelleryapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.jewelleryapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FragmentHomeBinding fragmentHomeBinding;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Access views through binding
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

        // You can add images with or without titles
        imageList.add(new SlideModel (R.drawable.slider_img1, ScaleTypes.FIT));
        imageList.add(new SlideModel (R.drawable.slider_img2, ScaleTypes.FIT));
        imageList.add(new SlideModel (R.drawable.slider_img3, ScaleTypes.FIT));
        imageList.add(new SlideModel (R.drawable.slider_img4, ScaleTypes.FIT));
        fragmentHomeBinding.imageSliderId.setImageList(imageList);

        ArrayList<HomeItemModel> arrHomeItem = new ArrayList<>();

        arrHomeItem.add(new HomeItemModel(R.drawable.bracelet_1,"Womens","$76683"));
        arrHomeItem.add(new HomeItemModel(R.drawable.ring_4,"Womens","$76683"));
        arrHomeItem.add(new HomeItemModel(R.drawable.ring_8,"Womens","$76683"));
        arrHomeItem.add(new HomeItemModel(R.drawable.bracelet_8,"Womens","$76683"));
        arrHomeItem.add(new HomeItemModel(R.drawable.bracelet_10,"Womens","$76683"));
        arrHomeItem.add(new HomeItemModel(R.drawable.bracelet_5,"Womens","$76683"));
        arrHomeItem.add(new HomeItemModel(R.drawable.ring_2,"Womens","$76683"));
        arrHomeItem.add(new HomeItemModel(R.drawable.ring_1,"Womens","$76683"));

//        fragmentHomeBinding.gridViewHome.setAdapter(new GridViewAdapter(requireContext(),R.layout.recycler_item_home,arrHomeItem));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Release binding instance
        fragmentHomeBinding = null;
    }


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
//    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentHomeBinding = FragmentHomeBinding.inflate(getLayoutInflater());

    }

}
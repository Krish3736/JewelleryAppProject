package com.example.jewelleryapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jewelleryapp.databinding.FragmentCategoryBinding;
import com.example.jewelleryapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {
    FragmentCategoryBinding fragmentCategoryBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCategoryBinding = FragmentCategoryBinding.inflate(inflater, container, false);
        return fragmentCategoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentCategoryBinding.recyclerCategoryId.setLayoutManager(new LinearLayoutManager(requireContext()));

        ArrayList<HomeItemModel> arrCategoryItem = new ArrayList<>();

        arrCategoryItem.add(new HomeItemModel(R.drawable.category_background_image2,"Radiant Rings"));
        arrCategoryItem.add(new HomeItemModel(R.drawable.category_background_image1,"Noble Necklaces"));
        arrCategoryItem.add(new HomeItemModel(R.drawable.category_background_image3,"Elegant Earrings"));
        arrCategoryItem.add(new HomeItemModel(R.drawable.category_background_image5,"Precious Pendant"));
        arrCategoryItem.add(new HomeItemModel(R.drawable.category_background_image2,"Charming Chains"));
        arrCategoryItem.add(new HomeItemModel(R.drawable.category_background_image1,"Beautiful Bracelets"));
        arrCategoryItem.add(new HomeItemModel(R.drawable.category_background_image3,"Blissful Bangles"));


        fragmentCategoryBinding.recyclerCategoryId.setAdapter(new CategoryAdapter(requireContext(),arrCategoryItem));
    }
}
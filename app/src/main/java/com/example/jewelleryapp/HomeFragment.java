package com.example.jewelleryapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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

        String[] names = {"Mirthful Elegance Diamond Bracelet", "Flowering Wine Finger Ring", "Plume Peacock Gold Pendant", "Beautiful Diamond Bracelet", "Elegance Rose Gold Watch", "Ainoah Graceful Necklace", "Elegant Kundan Earrings", "Omkar Glow Diamond Pendant"};
        String[] prices = {"₹ 76,135", "₹ 58,144", "₹ 64,199", "₹ 69,999", "₹ 1,06,130", "₹ 1,34,986", "₹ 48,999", "₹ 89,549"};
        int[] imageResourceIds = {R.drawable.bracelet_5, R.drawable.ring_10, R.drawable.pendant_3, R.drawable.bracelet_3, R.drawable.watch_5, R.drawable.necklace_2, R.drawable.earrings_1, R.drawable.pendant_5};

        // Array of CardView IDs
        int[] cardViewIds = {R.id.home_card_id_1, R.id.home_card_id_2, R.id.home_card_id_3, R.id.home_card_id_4, R.id.home_card_id_5, R.id.home_card_id_6, R.id.home_card_id_7, R.id.home_card_id_8};

        // Set OnClickListener for each CardView dynamically
        for (int i = 0; i < cardViewIds.length; i++) {
            CardView cardView = requireView().findViewById(cardViewIds[i]);
            final String name = names[i];
            final String price = prices[i];
            final int imageResourceId = imageResourceIds[i];

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openItemDescriptionActivity(name, price, imageResourceId);
                }
            });
        }
    }

    private void openItemDescriptionActivity(String name, String price, int imageResourceId) {
        Intent intent = new Intent(getActivity(), ItemDescription.class);
        intent.putExtra("item_image", imageResourceId);
        intent.putExtra("item_name", name);
        intent.putExtra("item_price", price);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Release binding instance
        fragmentHomeBinding = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentHomeBinding = FragmentHomeBinding.inflate(getLayoutInflater());

    }

}
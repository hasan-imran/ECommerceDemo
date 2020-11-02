package com.example.ecommercedemo.fragments.navigation_items.mywishlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.adapters.WishlistItemAdapter;
import com.example.ecommercedemo.models.WishlistItemModel;

import java.util.ArrayList;
import java.util.List;


public class MyWishlistFragment extends Fragment {

    private RecyclerView rvWishlistItemHolder;
    private WishlistItemAdapter wishlistItemAdapter;

    public MyWishlistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        rvWishlistItemHolder = view.findViewById(R.id.rvWishlistItemHolder);
        rvWishlistItemHolder.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvWishlistItemHolder.setLayoutManager(layoutManager);

        List<WishlistItemModel> wishlistItems = new ArrayList<>();
        wishlistItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                "1754", "BDT 150000/-", "BDT 175000/-"));
        wishlistItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                "1754", "BDT 150000/-", "BDT 175000/-"));
        wishlistItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                "1754", "BDT 150000/-", "BDT 175000/-"));
        wishlistItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                "1754", "BDT 150000/-", "BDT 175000/-"));
        wishlistItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                "1754", "BDT 150000/-", "BDT 175000/-"));
        wishlistItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                "1754", "BDT 150000/-", "BDT 150000/-"));
        wishlistItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                "1754", "BDT 150000/-", "BDT 175000/-"));

        wishlistItemAdapter = new WishlistItemAdapter(wishlistItems);

        rvWishlistItemHolder.setAdapter(wishlistItemAdapter);
        wishlistItemAdapter.notifyDataSetChanged();

        return view;
    }
}
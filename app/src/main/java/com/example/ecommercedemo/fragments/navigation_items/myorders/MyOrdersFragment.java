package com.example.ecommercedemo.fragments.navigation_items.myorders;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.adapters.MyOrderItemAdapter;
import com.example.ecommercedemo.models.MyOrderItemModel;

import java.util.ArrayList;
import java.util.List;


public class MyOrdersFragment extends Fragment {

    public MyOrdersFragment() {
    }

    private RecyclerView rvMyOrders;
    private MyOrderItemAdapter myOrderItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_my_orders, container, false);

        rvMyOrders = view.findViewById(R.id.rvMyOrders);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMyOrders.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItems = new ArrayList<>();
        myOrderItems.add(new MyOrderItemModel(R.drawable.iphone_12_pro_max, 4,
                "iPhone 12 Max Pro", "Cancelled"));
        myOrderItems.add(new MyOrderItemModel(R.drawable.iphone_12_pro_max, 1,
                "iPhone 12 Max Pro", "Delivered"));
        myOrderItems.add(new MyOrderItemModel(R.drawable.iphone_12_pro_max, 3,
                "iPhone 12 Max Pro", "Delivered"));
        myOrderItems.add(new MyOrderItemModel(R.drawable.iphone_12_pro_max, 2,
                "iPhone 12 Max Pro", "Delivered"));

        myOrderItemAdapter = new MyOrderItemAdapter(myOrderItems);
        rvMyOrders.setAdapter(myOrderItemAdapter);
        rvMyOrders.setHasFixedSize(true);
        myOrderItemAdapter.notifyDataSetChanged();

        return view;
    }


}
package com.example.ecommercedemo.fragments.navigation_items.mycart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecommercedemo.AddAddressActivity;
import com.example.ecommercedemo.DeliveryActivity;
import com.example.ecommercedemo.MainActivity;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.adapters.CartItemAdapter;
import com.example.ecommercedemo.models.CartItemModel;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment  implements View.OnClickListener {

    private RecyclerView rvCartItems;
    private Button btnContinueCartShopping;

    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        rvCartItems = view.findViewById(R.id.rvCartItems);

        btnContinueCartShopping = view.findViewById(R.id.btnContinueCartShopping);
        btnContinueCartShopping.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCartItems.setLayoutManager(layoutManager);
        rvCartItems.setHasFixedSize(true);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));


        CartItemAdapter cartItemAdapter = new CartItemAdapter(cartItemModelList);
        cartItemAdapter.notifyDataSetChanged();

        rvCartItems.setAdapter(cartItemAdapter);

        return view;
    }

    @Override
    public void onClick(View v) {
        int clickedId = v.getId();
        if(clickedId == R.id.btnContinueCartShopping){
            Intent intent = new Intent(getContext(), AddAddressActivity.class);
            startActivity(intent);
        }
    }
}
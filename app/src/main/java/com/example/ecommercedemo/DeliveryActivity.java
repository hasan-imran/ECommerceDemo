package com.example.ecommercedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ecommercedemo.adapters.CartItemAdapter;
import com.example.ecommercedemo.models.CartItemModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.ecommercedemo.Constants.SELECT_ADDRESS;


public class DeliveryActivity extends AppCompatActivity implements View.OnClickListener {



    private Toolbar toolbar;
    private RecyclerView rvDeliveryItems;
    private Button btnChangeOrAddAddress;
    private Button btnMyAccountAddressViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        rvDeliveryItems = findViewById(R.id.rvDeliveryItems);
        btnChangeOrAddAddress = findViewById(R.id.btnMyAccountChangeOrAddAddress);
        btnChangeOrAddAddress.setVisibility(View.VISIBLE);
        btnChangeOrAddAddress.setOnClickListener(this);

        btnMyAccountAddressViewAll = findViewById(R.id.btnMyAccountAddressViewAll);
        btnMyAccountAddressViewAll.setOnClickListener(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDeliveryItems.setLayoutManager(layoutManager);
        rvDeliveryItems.setHasFixedSize(true);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));


        CartItemAdapter cartItemAdapter = new CartItemAdapter(cartItemModelList);
        cartItemAdapter.notifyDataSetChanged();

        rvDeliveryItems.setAdapter(cartItemAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int clickedId = item.getItemId();
        if(clickedId == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int clickedId = v.getId();
        if(clickedId == R.id.btnMyAccountChangeOrAddAddress){
            Intent intent = new Intent(DeliveryActivity.this, AddAddressActivity.class);
            startActivity(intent);
        }
        else if(clickedId == R.id.btnMyAccountAddressViewAll){
            Intent intent = new Intent(DeliveryActivity.this, MyAddressesActivity.class);
            intent.putExtra(Constants.ADDRESS_MODE_KEY, Constants.SELECT_ADDRESS);
            startActivity(intent);
        }
    }
}
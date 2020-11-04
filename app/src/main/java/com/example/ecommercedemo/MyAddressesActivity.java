package com.example.ecommercedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ecommercedemo.adapters.AddressAdapter;
import com.example.ecommercedemo.models.AddressModel;

import java.util.ArrayList;
import java.util.List;

public class MyAddressesActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    private RecyclerView rvDeliveryAddresses;
    private LinearLayout llBtnAddNewAddress;
    private Button btnDeliverHere;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Addresses");

        rvDeliveryAddresses = findViewById(R.id.rvDeliveryAddresses);
        llBtnAddNewAddress = findViewById(R.id.llBtnAddNewAddress);
        btnDeliverHere = findViewById(R.id.btnDeliverHere);


        llBtnAddNewAddress.setOnClickListener(this);
        btnDeliverHere.setOnClickListener(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDeliveryAddresses.setLayoutManager(layoutManager);

        List<AddressModel> addresses = new ArrayList<>();
        addresses.add(new AddressModel("Md Imran Hasan", "Parkmore, Rangpur, 5400", "1221"));
        addresses.add(new AddressModel("Md Imran Hasan", "Parkmore, Rangpur, 5400", "1221"));
        addresses.add(new AddressModel("Md Imran Hasan", "Parkmore, Rangpur, 5400", "1221"));
        addresses.add(new AddressModel("Md Imran Hasan", "Parkmore, Rangpur, 5400", "1221"));
        addresses.add(new AddressModel("Md Imran Hasan", "Parkmore, Rangpur, 5400", "1221"));


        addressAdapter = new AddressAdapter(addresses);
        rvDeliveryAddresses.setAdapter(addressAdapter);
        rvDeliveryAddresses.setHasFixedSize(true);
        addressAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int clickedItem = item.getItemId();
        if(clickedItem == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int clickedId = v.getId();
        if(clickedId == R.id.llBtnAddNewAddress){

        }
        else if(clickedId == R.id.btnDeliverHere){

        }
    }
}
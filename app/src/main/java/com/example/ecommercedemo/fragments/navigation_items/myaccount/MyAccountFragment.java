package com.example.ecommercedemo.fragments.navigation_items.myaccount;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecommercedemo.Constants;
import com.example.ecommercedemo.MyAddressesActivity;
import com.example.ecommercedemo.R;


public class MyAccountFragment extends Fragment implements View.OnClickListener {


    private Button btnMyAccountAddressViewAll;


    public MyAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_account, container, false);

        btnMyAccountAddressViewAll = view.findViewById(R.id.btnMyAccountAddressViewAll);
        btnMyAccountAddressViewAll.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int clickedId = v.getId();
        if(clickedId == R.id.btnMyAccountAddressViewAll){
            Intent intent = new Intent(getContext(), MyAddressesActivity.class);
            intent.putExtra(Constants.ADDRESS_MODE_KEY, Constants.MODIFY_ADDRESS);
            startActivity(intent);
        }
    }
}
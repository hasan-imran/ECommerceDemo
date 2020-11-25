package com.example.ecommercedemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercedemo.Constants;
import com.example.ecommercedemo.DeliveryActivity;
import com.example.ecommercedemo.MyAddressesActivity;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.fragments.navigation_items.myaccount.MyAccountFragment;
import com.example.ecommercedemo.models.AddressModel;


import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {

    private List<AddressModel> addresses;
    private int addressMode;
    private int preSelectedAddressPosition = -1;

    public AddressAdapter(List<AddressModel> addresses, int addressMode) {
        this.addresses = addresses;
        this.addressMode = addressMode;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.address_item_layout, parent, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        String fullName = addresses.get(position).getFullName();
        String address = addresses.get(position).getAddress();
        String pinCode = addresses.get(position).getPinCode();
        boolean isAddressSelected = addresses.get(position).isAddressSelected();

        holder.setAddressDetails(fullName, address, pinCode, isAddressSelected, position);
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public class AddressViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAddressItemFullName;
        private TextView tvAddressItemAddress;
        private TextView tvAddressItemPinCode;
        private ImageView ivAddressItemSelectedIcon;
        private LinearLayout llAddressItemMoreOptions;
        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAddressItemFullName = itemView.findViewById(R.id.tvAddressItemFullName);
            tvAddressItemAddress = itemView.findViewById(R.id.tvAddressItemAddress);
            tvAddressItemPinCode = itemView.findViewById(R.id.tvAddressItemPinCode);
            ivAddressItemSelectedIcon = itemView.findViewById(R.id.ivAddressItemSelectedIcon);
            llAddressItemMoreOptions = itemView.findViewById(R.id.llAddressItemMoreOptions);
        }

        private void setAddressDetails(String fullName, String address, String pinCode, boolean isAddressSelected, int position){
            tvAddressItemFullName.setText(fullName);
            tvAddressItemAddress.setText(address);
            tvAddressItemPinCode.setText(pinCode);

           if(addressMode == Constants.SELECT_ADDRESS){
               if(isAddressSelected){
                   ivAddressItemSelectedIcon.setVisibility(View.VISIBLE);
                   preSelectedAddressPosition = position;
               }
               else{
                   ivAddressItemSelectedIcon.setVisibility(View.GONE);
               }
               itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if(preSelectedAddressPosition != position){
                           addresses.get(position).setAddressSelected(true);
                           addresses.get(preSelectedAddressPosition).setAddressSelected(false);
                           MyAddressesActivity.refreshItem(position, preSelectedAddressPosition);
                           preSelectedAddressPosition = position;
                       }
                   }
               });
           }
            else if(addressMode == Constants.MODIFY_ADDRESS){
                llAddressItemMoreOptions.setVisibility(View.GONE);
                ivAddressItemSelectedIcon.setImageResource(R.drawable.ic_more_vertical);
                ivAddressItemSelectedIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        llAddressItemMoreOptions.setVisibility(View.VISIBLE);
                        MyAddressesActivity.refreshItem(preSelectedAddressPosition, preSelectedAddressPosition);
                        preSelectedAddressPosition = position;
                    }
                });
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyAddressesActivity.refreshItem(preSelectedAddressPosition, preSelectedAddressPosition);
                        preSelectedAddressPosition = -1;
                    }
                });
           }
        }
    }
}

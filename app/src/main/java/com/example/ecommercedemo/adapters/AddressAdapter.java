package com.example.ecommercedemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.models.AddressModel;


import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {

    private List<AddressModel> addresses;

    public AddressAdapter(List<AddressModel> addresses) {
        this.addresses = addresses;
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

        holder.setAddressDetails(fullName, address, pinCode);
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public class AddressViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAddressItemFullName;
        private TextView tvAddressItemAddress;
        private TextView tvAddressItemPinCode;
        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAddressItemFullName = itemView.findViewById(R.id.tvAddressItemFullName);
            tvAddressItemAddress = itemView.findViewById(R.id.tvAddressItemAddress);
            tvAddressItemPinCode = itemView.findViewById(R.id.tvAddressItemPinCode);
        }

        private void setAddressDetails(String fullName, String address, String pinCode){
            tvAddressItemFullName.setText(fullName);
            tvAddressItemAddress.setText(address);
            tvAddressItemPinCode.setText(pinCode);
        }
    }
}

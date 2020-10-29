package com.example.ecommercedemo.adapters;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.models.CartItemModel;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {

    private List<CartItemModel> cartItemModelList;

    public CartItemAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }



    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cart_item_layout, parent, false);
        return new CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
            int itemImageResource = cartItemModelList.get(position).getCartItemImageResource();
            String itemTitle = cartItemModelList.get(position).getCartItemTitle();
            String itemPrice = cartItemModelList.get(position).getCartItemPrice();
            String itemCuttedPrice = cartItemModelList.get(position).getCartItemCuttedPrice();
            int itemQuantity = cartItemModelList.get(position).getItemQuantity();

            holder.setCartItemDetails(itemImageResource, itemTitle, itemQuantity, itemPrice, itemCuttedPrice);
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivCartItemImage;
        private TextView tvCartItemTitle;
        private TextView tvCartItemPrice;
        private TextView tvCartItemCuttedPrice;
        private TextView tvCartItemQuantity;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCartItemImage = itemView.findViewById(R.id.ivCartItemImage);
            tvCartItemTitle = itemView.findViewById(R.id.tvCartItemTitle);
            tvCartItemPrice = itemView.findViewById(R.id.tvCartItemPrice);
            tvCartItemCuttedPrice = itemView.findViewById(R.id.tvCartItemCuttedPrice);
            tvCartItemQuantity = itemView.findViewById(R.id.tvCartItemQuantity);
        }

        @SuppressLint("SetTextI18n")
        private void setCartItemDetails(int itemImageResource, String itemTitle, int itemQuantity,
                                        String itemPrice, String itemCuttedPrice){
            ivCartItemImage.setImageResource(itemImageResource);
            tvCartItemTitle.setText(itemTitle);
            tvCartItemQuantity.setText("Qty: " +  itemQuantity);
            tvCartItemPrice.setText(itemPrice);
            tvCartItemCuttedPrice.setText(itemCuttedPrice);
        }
    }
}

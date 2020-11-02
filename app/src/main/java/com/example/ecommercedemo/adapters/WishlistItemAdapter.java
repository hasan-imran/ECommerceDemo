package com.example.ecommercedemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.models.WishlistItemModel;

import java.util.List;

public class WishlistItemAdapter extends RecyclerView.Adapter<WishlistItemAdapter.WishlistItemViewHolder> {

    private List<WishlistItemModel> wishlistItems;

    public WishlistItemAdapter(List<WishlistItemModel> wishlistItems) {
        this.wishlistItems = wishlistItems;
    }

    @NonNull
    @Override
    public WishlistItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.wishlist_item_layout, parent, false);
        return new WishlistItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistItemViewHolder holder, int position) {
        int image = wishlistItems.get(position).getItemImageResource();
        String title = wishlistItems.get(position).getItemTitle();
        String rating = wishlistItems.get(position).getItemRating();
        String totalRatings = wishlistItems.get(position).getItemTotalRatings();
        String price = wishlistItems.get(position).getItemPrice();
        String cuttedPrice = wishlistItems.get(position).getItemCuttedPrice();

        holder.setWishlistItemDetails(image, title, rating, totalRatings, price, cuttedPrice);
    }

    @Override
    public int getItemCount() {
        return wishlistItems.size();
    }

    public class WishlistItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivWishlistItemImage;
        private TextView tvWishlistItemTitle;
        private TextView tvWishlistItemRating;
        private TextView tvWishlistItemTotalRatings;
        private TextView tvWishlistItemPrice;
        private TextView tvWishlistItemCuttedPrice;
        private ImageView ivWishlistItemDelete;
        private View priceCutter;

        public WishlistItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivWishlistItemImage = itemView.findViewById(R.id.ivWishListItemImage);
            tvWishlistItemTitle = itemView.findViewById(R.id.tvWishlistItemTitle);
            tvWishlistItemRating = itemView.findViewById(R.id.tvWishListItemRating);
            tvWishlistItemTotalRatings = itemView.findViewById(R.id.tvWishlistItemTotalRatings);
            tvWishlistItemPrice = itemView.findViewById(R.id.tvWishlistItemPrice);
            tvWishlistItemCuttedPrice = itemView.findViewById(R.id.tvWishListItemCuttedPrice);
            ivWishlistItemDelete = itemView.findViewById(R.id.ivWishlistItemDelete);
            priceCutter = itemView.findViewById(R.id.priceCutter);

            ivWishlistItemDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Delete button clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
        private void setWishlistItemDetails(int image, String title, String rating, String totalRatings, String price, String cuttedPrice){
            ivWishlistItemImage.setImageResource(image);
            tvWishlistItemTitle.setText(title);
            tvWishlistItemRating.setText(rating);
            tvWishlistItemTotalRatings.setText(totalRatings);
            tvWishlistItemPrice.setText(price);
            if(price.trim().equals(cuttedPrice.trim())) {
                tvWishlistItemCuttedPrice.setVisibility(View.INVISIBLE);
                priceCutter.setVisibility(View.INVISIBLE);
            }
            tvWishlistItemCuttedPrice.setText(cuttedPrice);
        }
    }
}

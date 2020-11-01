package com.example.ecommercedemo.adapters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.models.MyOrderItemModel;

import java.util.List;

public class MyOrderItemAdapter extends RecyclerView.Adapter<MyOrderItemAdapter.MyOrderItemViewHolder> {

    private List<MyOrderItemModel> myOrderItemModels;

    public MyOrderItemAdapter(List<MyOrderItemModel> myOrderItemModels) {
        this.myOrderItemModels = myOrderItemModels;
    }

    @NonNull
    @Override
    public MyOrderItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_orders_layout_item_layout, parent, false);
        return new MyOrderItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderItemViewHolder holder, int position) {
        int itemImage = myOrderItemModels.get(position).getMyOrderItemImage();
        int itemRating = myOrderItemModels.get(position).getMyOrderItemRating();
        String itemTitle = myOrderItemModels.get(position).getMyOrderItemTitle();
        String itemDeliveryStatus = myOrderItemModels.get(position).getMyOrderItemDeliveryStatus();

        holder.setMyOrderItemDetails(itemImage, itemRating, itemTitle, itemDeliveryStatus);
    }

    @Override
    public int getItemCount() {
        return myOrderItemModels.size();
    }

    public class MyOrderItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivMyOrderItemImage;
        private ImageView ivMyOrderStatusIndicator;
        private TextView tvMyOrderItemTitle;
        private TextView tvMyOrderDeliveryStatus;
        private LinearLayout llRatingContainer;
        public MyOrderItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMyOrderItemImage = itemView.findViewById(R.id.ivMyOrderItemImage);
            ivMyOrderStatusIndicator = itemView.findViewById(R.id.ivMyOrderStatusIndicator);
            tvMyOrderItemTitle = itemView.findViewById(R.id.tvMyOrderItemTitle);
            tvMyOrderDeliveryStatus = itemView.findViewById(R.id.tvMyOrderDeliveryStatus);
            llRatingContainer = itemView.findViewById(R.id.llRatingContainer);
        }

        private void setMyOrderItemDetails(int itemImage, int itemRating, String itemTitle, String itemDeliveryStatus){
            ivMyOrderItemImage.setImageResource(itemImage);
            tvMyOrderItemTitle.setText(itemTitle);
            tvMyOrderDeliveryStatus.setText(itemDeliveryStatus);

            if(itemDeliveryStatus.trim().equals("Cancelled")) ivMyOrderStatusIndicator.setImageTintList(ColorStateList
                    .valueOf(itemView.getContext().getResources().getColor(R.color.status_indicator_red)));
            else ivMyOrderStatusIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext()
                    .getResources().getColor(R.color.status_indicator_green)));

            setRating(itemRating);
            for(int i = 0; i<llRatingContainer.getChildCount(); i++){
                final int starPosition = i;
                llRatingContainer.getChildAt(starPosition).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setRating(starPosition);
                    }
                });
            }
        }
        private void setRating(int starPosition){
            for(int i = 0; i<llRatingContainer.getChildCount(); i++){
                ImageView star = (ImageView) llRatingContainer.getChildAt(i);
                star.setImageTintList(ColorStateList.valueOf(itemView.getContext()
                .getResources().getColor(R.color.grey)));
                if(i<=starPosition) star.setImageTintList(ColorStateList.valueOf(itemView.getContext()
                        .getResources().getColor(R.color.star_selected)));
            }
        }
    }
}

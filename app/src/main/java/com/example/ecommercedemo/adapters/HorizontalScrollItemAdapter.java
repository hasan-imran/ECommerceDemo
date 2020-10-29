package com.example.ecommercedemo.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercedemo.ProductDetailsActivity;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.models.HorizontalScrollItemModel;

import java.util.List;

public class HorizontalScrollItemAdapter extends RecyclerView.Adapter<HorizontalScrollItemAdapter.HorizontalScrollItemViewHolder> {

    private static List<HorizontalScrollItemModel> horizontalScrollItems;

    public HorizontalScrollItemAdapter(List<HorizontalScrollItemModel> horizontalScrollItems) {
        this.horizontalScrollItems = horizontalScrollItems;
    }

    @NonNull
    @Override
    public HorizontalScrollItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.horizontal_scroll_item_layout, parent, false);
        return new HorizontalScrollItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalScrollItemViewHolder holder, int position) {

        int itemImage = horizontalScrollItems.get(position).getHorizontalScrollItemImageLink();
        String itemTitle = horizontalScrollItems.get(position).getHorizontalScrollItemTitle();
        String itemSubTitle = horizontalScrollItems.get(position).getHorizontalScrollItemSubTitle();
        String itemPrice = horizontalScrollItems.get(position).getHorizontalScrollItemPrice();

        holder.setItemImage(itemImage);
        holder.setItemTitle(itemTitle);
        holder.setItemSubTitle(itemSubTitle);
        holder.setItemPrice(itemPrice);
    }

    @Override
    public int getItemCount() {
        if(horizontalScrollItems.size()>8) return 8;
        return horizontalScrollItems.size();
    }

    public class HorizontalScrollItemViewHolder  extends RecyclerView.ViewHolder{
        private ImageView ivHorizontalScrollItemImage;
        private TextView tvHorizontalScrollItemTitle;
        private TextView tvHorizontalScrollItemSubTitle;
        private TextView tvHorizontalScrollItemPrice;
        public HorizontalScrollItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHorizontalScrollItemImage = itemView.findViewById(R.id.ivHorizontalScrollItemImage);
            tvHorizontalScrollItemTitle = itemView.findViewById(R.id.tvHorizontalScrollItemPrice);
            tvHorizontalScrollItemSubTitle = itemView.findViewById(R.id.tvHorizontalScrollItemSubTitle);
            tvHorizontalScrollItemPrice = itemView.findViewById(R.id.tvHorizontalScrollItemPrice);

            ivHorizontalScrollItemImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(intent);

                }
            });

            tvHorizontalScrollItemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(intent);

                }
            });
        }

        private void setItemImage(int image){
            ivHorizontalScrollItemImage.setImageResource(image);
        }

        private void setItemTitle(String title){
            tvHorizontalScrollItemTitle.setText(title);
        }

        private void setItemSubTitle(String subTitle){
            tvHorizontalScrollItemSubTitle.setText(subTitle);
        }

        private void setItemPrice(String price){
            tvHorizontalScrollItemPrice.setText(price);
        }
    }
}

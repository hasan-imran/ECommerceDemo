package com.example.ecommercedemo.adapters;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommercedemo.ProductDetailsActivity;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.models.HorizontalScrollItemModel;

import java.util.List;

public class GridProductLayoutAdapter  extends BaseAdapter {

    List<HorizontalScrollItemModel> gridProductList;

    public GridProductLayoutAdapter(List<HorizontalScrollItemModel> gridProductList) {
        this.gridProductList = gridProductList;
    }

    @Override
    public int getCount() {
        if(gridProductList.size() < 6) return gridProductList.size();
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.horizontal_scroll_item_layout, parent, false);
//            view.setElevation(0);
//            view.setBackgroundColor(Color.parseColor("#ffffff"));

            ImageView ivProductImage = view.findViewById(R.id.ivHorizontalScrollItemImage);
            TextView tvProductTitle = view.findViewById(R.id.tvHorizontalScrollItemTitle);
            TextView tvProductSubTitle = view.findViewById(R.id.tvHorizontalScrollItemSubTitle);
            TextView tvProductPrice = view.findViewById(R.id.tvHorizontalScrollItemPrice);

            ivProductImage.setImageResource(gridProductList.get(position).getHorizontalScrollItemImageLink());
            tvProductTitle.setText(gridProductList.get(position).getHorizontalScrollItemTitle());
            tvProductSubTitle.setText(gridProductList.get(position).getHorizontalScrollItemSubTitle());
            tvProductPrice.setText(gridProductList.get(position).getHorizontalScrollItemPrice());

            ivProductImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);
                    view.getContext().startActivity(intent);

                }
            });

            tvProductTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);
                    view.getContext().startActivity(intent);

                }
            });



        }
        else view = convertView;
        return view;
    }
}

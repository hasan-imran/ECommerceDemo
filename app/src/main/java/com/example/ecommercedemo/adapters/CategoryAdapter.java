package com.example.ecommercedemo.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercedemo.CategoryActivity;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.models.CategoryModel;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryItemsViewHolder> {
    public static final String CATEGORY_NAME_KEY = "category-name-key";

    private List<CategoryModel> categoryList;

    public CategoryAdapter(List<CategoryModel> categoryList){
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.category_menu_item, parent, false);
        return new CategoryItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemsViewHolder holder, int position) {
        String icon = categoryList.get(position).getCategoryIconLink();
        String name = categoryList.get(position).getCategoryName();

        holder.setTvCategoryName(name, position);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryItemsViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivCategoryIcon;
        private TextView tvCategoryName;
        public CategoryItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategoryIcon = itemView.findViewById(R.id.ivCategoryIcon);
            tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
        }

        private void setCategoryIcon(ImageView categoryIcon){

        }

        private void setTvCategoryName(String name, int position){
            tvCategoryName.setText(name);
            ivCategoryIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position != 0){
                        Intent intent = new Intent(v.getContext(), CategoryActivity.class);
                        intent.putExtra(CATEGORY_NAME_KEY, name);
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}

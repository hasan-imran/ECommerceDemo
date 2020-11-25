package com.example.ecommercedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.example.ecommercedemo.adapters.GridProductLayoutAdapter;
import com.example.ecommercedemo.adapters.WishlistItemAdapter;
import com.example.ecommercedemo.models.HorizontalScrollItemModel;
import com.example.ecommercedemo.models.WishlistItemModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rvViewAll;
    private GridView gvViewAll;
    private WishlistItemAdapter viewAllAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Trending Items");

        Intent intent = getIntent();
        int gridOrHorizontal = intent.getIntExtra(Constants.HOME_FRAG_VIEW_ALL_KEY, -1);

        gvViewAll = findViewById(R.id.gvViewAll);
        rvViewAll = findViewById(R.id.rvViewAll);
        rvViewAll.setHasFixedSize(true);

        if(gridOrHorizontal == Constants.HORIZONTAL_VIEW_ALL){
            rvViewAll.setVisibility(View.VISIBLE);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvViewAll.setLayoutManager(layoutManager);

            List<WishlistItemModel> horizontalViewAllItems = new ArrayList<>();
            horizontalViewAllItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                    "1754", "BDT 150000/-", "BDT 175000/-"));
            horizontalViewAllItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                    "1754", "BDT 150000/-", "BDT 175000/-"));
            horizontalViewAllItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                    "1754", "BDT 150000/-", "BDT 175000/-"));
            horizontalViewAllItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                    "1754", "BDT 150000/-", "BDT 175000/-"));
            horizontalViewAllItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                    "1754", "BDT 150000/-", "BDT 175000/-"));
            horizontalViewAllItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                    "1754", "BDT 150000/-", "BDT 150000/-"));
            horizontalViewAllItems.add(new WishlistItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Pro Max", "4.5",
                    "1754", "BDT 150000/-", "BDT 175000/-"));

            viewAllAdapter = new WishlistItemAdapter(horizontalViewAllItems, false);
            rvViewAll.setAdapter(viewAllAdapter);
            viewAllAdapter.notifyDataSetChanged();
        }
        else if(gridOrHorizontal == Constants.GRID_VIEW_ALL){
            gvViewAll.setVisibility(View.VISIBLE);
            List<HorizontalScrollItemModel> gridViewAllItems = new ArrayList<>();
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));
            gridViewAllItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                    "iPhone 12 max pro",
                    "128 GB",
                    "Price ৳150,000 TK"));

            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(gridViewAllItems);
            gvViewAll.setAdapter(gridProductLayoutAdapter);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.ecommercedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ecommercedemo.adapters.CategoryAdapter;
import com.example.ecommercedemo.adapters.HomePageAdapter;
import com.example.ecommercedemo.models.BannerSliderModel;
import com.example.ecommercedemo.models.HomePageModel;
import com.example.ecommercedemo.models.HorizontalScrollItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView rvCategoryLayoutItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if(intent!=null){
            String categoryName = intent.getStringExtra(CategoryAdapter.CATEGORY_NAME_KEY);
            getSupportActionBar().setTitle(categoryName);
        }

        rvCategoryLayoutItems = findViewById(R.id.rvCategoryLayoutItems);

        ////Dummy List To Test the application

        List<BannerSliderModel> banners = new ArrayList<>();

        banners.add(new BannerSliderModel(R.drawable.banner_2, "#000000"));

        banners.add(new BannerSliderModel(R.drawable.banner_1, "#000000"));
        banners.add(new BannerSliderModel(R.drawable.banner_2, "#000000"));

        banners.add(new BannerSliderModel(R.drawable.banner_1, "#000000"));



        List<HorizontalScrollItemModel> horizontalScrollItems = new ArrayList<>();

        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));
        horizontalScrollItems.add(new HorizontalScrollItemModel(R.drawable.iphone_12_pro_max,
                "iPhone 12 max pro",
                "128 GB",
                "Price ৳150,000 TK"));


        ////Dummy List To Test the application


        ///////////
        LinearLayoutManager homeLayoutManager = new LinearLayoutManager(this);
        rvCategoryLayoutItems.setLayoutManager(homeLayoutManager);
        rvCategoryLayoutItems.setHasFixedSize(true);

        List<HomePageModel> homePageModelList = new ArrayList<>();


        //showing advertise
        homePageModelList.add(new HomePageModel(1, R.drawable.add_1, "#000000"));

        //showing horizontal products
        homePageModelList.add(new HomePageModel(2, "Horizontal Products", horizontalScrollItems));

        //showing banners
        homePageModelList.add(new HomePageModel(0, banners));

        //showing grid products
        homePageModelList.add(new HomePageModel(3, "Grid Items", horizontalScrollItems));

        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModelList);
        rvCategoryLayoutItems.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();
        ///////////


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int clickedId = item.getItemId();
        if(clickedId == R.id.action_search){

        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.ecommercedemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.ecommercedemo.adapters.ProductImagesAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static boolean alreadyAddedToWishList = false;

    private ViewPager vpProductImages;
    private TabLayout tlViewPagerIndicator;
    private FloatingActionButton fabAddToWishList;
    private Button btnBuyNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        vpProductImages = findViewById(R.id.vpProductImages);
        tlViewPagerIndicator = findViewById(R.id.tlViewPagerIndicator);
        tlViewPagerIndicator.setupWithViewPager(vpProductImages, true);

        btnBuyNow = findViewById(R.id.btnBuyNow);
        btnBuyNow.setOnClickListener(this);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.iphone_12_pro_max);
        productImages.add(R.drawable.banner_1);
        productImages.add(R.drawable.banner_2);
        productImages.add(R.drawable.add_1);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        vpProductImages.setAdapter(productImagesAdapter);

        fabAddToWishList = findViewById(R.id.fabAddToWishList);
        fabAddToWishList.setOnClickListener(this::onClick);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int clickedItemId = item.getItemId();
        if(clickedItemId == R.id.action_cart){
            Intent intent = new Intent(ProductDetailsActivity.this, MainActivity.class);
            MainActivity.showCart = true;
            startActivity(intent);
            return true;
        }
        else if(clickedItemId == R.id.action_search){
            return true;
        }
        else if(clickedItemId == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int clickedId = v.getId();
        if(clickedId == R.id.fabAddToWishList){
            if(alreadyAddedToWishList){
                alreadyAddedToWishList = false;
                fabAddToWishList.setImageTintList(ColorStateList.valueOf(Color.parseColor("#555454")));
            }
            else{
                alreadyAddedToWishList = true;
                //ViewCompat.setBackgroundTintList(fabAddToWishList, ColorStateList.valueOf(getResources().getColor(R.color.sky_blue)));
                fabAddToWishList.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.sky_blue)));
            }
        }
        else if(clickedId == R.id.btnBuyNow){
            Intent intent = new Intent(ProductDetailsActivity.this, DeliveryActivity.class);
            startActivity(intent);
        }
    }
}
package com.example.ecommercedemo.fragments.navigation_items.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.adapters.BannerSliderAdapter;
import com.example.ecommercedemo.adapters.CategoryAdapter;
import com.example.ecommercedemo.adapters.GridProductLayoutAdapter;
import com.example.ecommercedemo.adapters.HomePageAdapter;
import com.example.ecommercedemo.adapters.HorizontalScrollItemAdapter;
import com.example.ecommercedemo.models.BannerSliderModel;
import com.example.ecommercedemo.models.CategoryModel;
import com.example.ecommercedemo.models.HomePageModel;
import com.example.ecommercedemo.models.HorizontalScrollItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    private RecyclerView rvCategory;
    private CategoryAdapter categoryAdapter;
    private RecyclerView rvHomePageContainer;



    @SuppressLint({"ClickableViewAccessibility", "ResourceType"})
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        rvCategory = root.findViewById(R.id.rvCategory);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvCategory.setLayoutManager(layoutManager);
        rvCategory.setHasFixedSize(true);

        List<CategoryModel> categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel("link", "Home"));
        categoryModelList.add(new CategoryModel("link", "Phones"));
        categoryModelList.add(new CategoryModel("link", "Computers"));
        categoryModelList.add(new CategoryModel("link", "Fashion"));
        categoryModelList.add(new CategoryModel("link", "Toys"));
        categoryModelList.add(new CategoryModel("link", "Gadget"));
        categoryModelList.add(new CategoryModel("link", "Others"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        rvCategory.setAdapter(categoryAdapter);


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });


        ////Dummy List To Test the application

        List<BannerSliderModel> banners = new ArrayList<>();

       // banners.add(new BannerSliderModel(R.drawable.banner_2, "#000000"));

        banners.add(new BannerSliderModel(R.drawable.banner_1, "#000000"));
        banners.add(new BannerSliderModel(R.drawable.banner_2, "#000000"));
        banners.add(new BannerSliderModel(R.drawable.ic_cart_black, "#000000"));
        banners.add(new BannerSliderModel(R.drawable.ic__arrow_drop_down, "#000000"));
        banners.add(new BannerSliderModel(R.drawable.ic_account_black, "#000000"));

       // banners.add(new BannerSliderModel(R.drawable.banner_1, "#000000"));



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
        rvHomePageContainer = root.findViewById(R.id.rvHomePageContainer);
        LinearLayoutManager homeLayoutManager = new LinearLayoutManager(getContext());
        rvHomePageContainer.setLayoutManager(homeLayoutManager);
        rvHomePageContainer.setHasFixedSize(true);

        List<HomePageModel> homePageModelList = new ArrayList<>();


        //showing advertise
        homePageModelList.add(new HomePageModel(1, R.drawable.add_1, "#000000"));

        //showing horizontal products
        homePageModelList.add(new HomePageModel(2, "Horizontal Products", horizontalScrollItems));

        //showing banners
        homePageModelList.add(new HomePageModel(0, banners));

        //showing grid products
        homePageModelList.add(new HomePageModel(3, "Grid Items", horizontalScrollItems));

         //showing advertise
        homePageModelList.add(new HomePageModel(1, R.drawable.add_1, "#000000"));

        //showing horizontal products
        homePageModelList.add(new HomePageModel(2, "Horizontal Products", horizontalScrollItems));

        //showing banners
        homePageModelList.add(new HomePageModel(0, banners));

        //showing grid products
        homePageModelList.add(new HomePageModel(3, "Grid Items", horizontalScrollItems));

         //showing advertise
        homePageModelList.add(new HomePageModel(1, R.drawable.add_1, "#000000"));

        //showing horizontal products
        homePageModelList.add(new HomePageModel(2, "Horizontal Products", horizontalScrollItems));

        //showing banners
        homePageModelList.add(new HomePageModel(0, banners));

        //showing grid products
        homePageModelList.add(new HomePageModel(3, "Grid Items", horizontalScrollItems));

        

        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModelList);
        rvHomePageContainer.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();
        ///////////



        return root;
    }
}
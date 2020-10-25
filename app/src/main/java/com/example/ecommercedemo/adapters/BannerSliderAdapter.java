package com.example.ecommercedemo.adapters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.models.BannerSliderModel;

import java.util.List;

public class BannerSliderAdapter extends PagerAdapter {

    private List<BannerSliderModel> banners;

    public BannerSliderAdapter(List<BannerSliderModel> banners) {
        this.banners = banners;
    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.banner_slider_item_layout, container, false);
        ConstraintLayout clBannerItemContainerLayout = view.findViewById(R.id.clBannerItemContainerLayout);
        clBannerItemContainerLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(banners.get(position).getBackgroundColor())));
        ImageView banner = view.findViewById(R.id.ivBannerImage);
        banner.setImageResource(banners.get(position).getBannerId());
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

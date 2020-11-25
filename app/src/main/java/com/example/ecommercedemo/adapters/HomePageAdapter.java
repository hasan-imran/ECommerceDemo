package com.example.ecommercedemo.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.ecommercedemo.Constants;
import com.example.ecommercedemo.ProductDetailsActivity;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.ViewAllActivity;
import com.example.ecommercedemo.models.BannerSliderModel;
import com.example.ecommercedemo.models.HomePageModel;
import com.example.ecommercedemo.models.HorizontalScrollItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter{

    private List<HomePageModel> homePageModelList;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
        this.recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public int getItemViewType(int position) {
        if(homePageModelList.get(position).getType() == 0){
            return HomePageModel.BANNER_SLIDER_ID;
        }
        else if(homePageModelList.get(position).getType() == 1){
            return HomePageModel.ADVERTISEMENT_ID;
        }
        else if(homePageModelList.get(position).getType() == 2){
            return HomePageModel.HORIZONTAL_ITEM_VIEW_ID;
        }
        else if(homePageModelList.get(position).getType() == 3){
            return HomePageModel.GRID_ITEM_VIEW_ID;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if(viewType == HomePageModel.BANNER_SLIDER_ID){
            View view = inflater.inflate(R.layout.banner_slider_layout, parent, false);
            return new BannerSliderHolder(view);
        }
        else if(viewType == HomePageModel.ADVERTISEMENT_ID){
            View view = inflater.inflate(R.layout.ad_item_layout, parent, false);
            return new AdvertisementHolder(view);
        }
        else if(viewType == HomePageModel.HORIZONTAL_ITEM_VIEW_ID){
            View view = inflater.inflate(R.layout.horizontal_scroll_layout, parent, false);
            return new HorizontalItemViewHolder(view);
        }
        else if(viewType == HomePageModel.GRID_ITEM_VIEW_ID){
            View view = inflater.inflate(R.layout.grid_product_item_layout, parent, false);
            return new GridItemViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = homePageModelList.get(position).getType();
        if(type == HomePageModel.BANNER_SLIDER_ID){
            List<BannerSliderModel> banners = homePageModelList.get(position).getBanners();
            ((BannerSliderHolder) holder).setVpBannerSlider(banners);
        }

        else if(type == HomePageModel.ADVERTISEMENT_ID){
            int imageResource = homePageModelList.get(position).getImageResource();
            String backgroundColor = homePageModelList.get(position).getBackgroundColor();
            ((AdvertisementHolder) holder).setUpAd(imageResource, backgroundColor);
        }
        else if(type == HomePageModel.HORIZONTAL_ITEM_VIEW_ID){
            List<HorizontalScrollItemModel> horizontalScrollItemModelList = homePageModelList.get(position)
                    .getItems();
            String itemTitle = homePageModelList.get(position).getTitle();
            ((HorizontalItemViewHolder) holder).setHorizontalLayout(horizontalScrollItemModelList, itemTitle);
        }
        else if(type == HomePageModel.GRID_ITEM_VIEW_ID){
            List<HorizontalScrollItemModel> gridItems= homePageModelList.get(position).getItems();
            String itemTitle = homePageModelList.get(position).getTitle();
            ((GridItemViewHolder) holder).setGridItems(gridItems, itemTitle);
        }
        return;
    }


    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }

    public class BannerSliderHolder extends RecyclerView.ViewHolder {

        private ViewPager vpBannerSlider;
        private BannerSliderAdapter bannerSliderAdapter;
        private int currentPage;
        private Timer timer;
        private final long DELAY = 3000;
        private final long INTERVAL = 3000;
        private List<BannerSliderModel> arrangedBanners;
        @SuppressLint("ClickableViewAccessibility")
        public BannerSliderHolder(@NonNull View itemView) {
            super(itemView);
            vpBannerSlider = itemView.findViewById(R.id.vpBannerSlider);


        }

        @SuppressLint("ClickableViewAccessibility")
        private void setVpBannerSlider(List<BannerSliderModel> banners){

            if(timer != null){
                timer.cancel();
            }

            arrangedBanners = new ArrayList<>();

            arrangedBanners.add(banners.get(banners.size()-1));
            arrangedBanners.addAll(banners);
            arrangedBanners.add(banners.get(0));

            bannerSliderAdapter = new BannerSliderAdapter(arrangedBanners);
            vpBannerSlider.setCurrentItem(currentPage);
            vpBannerSlider.setAdapter(bannerSliderAdapter);
            vpBannerSlider.setClipToPadding(false);
            vpBannerSlider.setPageMargin(20);

            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    currentPage = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if(state == ViewPager.SCROLL_STATE_IDLE){
                        pageLooper(arrangedBanners);
                    }
                }
            };

            vpBannerSlider.addOnPageChangeListener(onPageChangeListener);

            startSlide(arrangedBanners);

            vpBannerSlider.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pageLooper(arrangedBanners);
                    stopSlide();
                    if(event.getAction() == MotionEvent.ACTION_UP){
                        startSlide(arrangedBanners);
                    }
                    return false;
                }


            });
        }

        private void pageLooper(List<BannerSliderModel> banners){
            if(currentPage == banners.size()-1){
                currentPage = 1;
                vpBannerSlider.setCurrentItem(currentPage, false);
            }
            else if(currentPage == 0){
                currentPage = banners.size()-2;
                vpBannerSlider.setCurrentItem(currentPage, false);
            }
        }

        private synchronized void startSlide(List<BannerSliderModel> banners){
            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if(currentPage>=banners.size()) currentPage = 0;
                    vpBannerSlider.setCurrentItem(currentPage++, true);
                }

            };

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            }, DELAY, INTERVAL);
        }

        private void stopSlide(){
            timer.cancel();
        }
    }

    public class AdvertisementHolder extends RecyclerView.ViewHolder{

        private ImageView ivAdvertiseImage;
        private ConstraintLayout clAdItemContainerLayout;

        public AdvertisementHolder(@NonNull View itemView) {
            super(itemView);
            ivAdvertiseImage = itemView.findViewById(R.id.ivAdvertiseImage);
            clAdItemContainerLayout = itemView.findViewById(R.id.clAdItemContainerLayout);
        }

        private void setUpAd(int imageResource, String backgroundColor){
            ivAdvertiseImage.setImageResource(imageResource);
            clAdItemContainerLayout.setBackgroundColor(Color.parseColor(backgroundColor));
        }
    }

    public class HorizontalItemViewHolder extends RecyclerView.ViewHolder{

        private TextView tvHorizontalItemLayoutTitle;
        private Button btnHorizontalItemLayoutViewAll;
        private RecyclerView rvHorizontalItemHolder;


        public HorizontalItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHorizontalItemLayoutTitle = itemView.findViewById(R.id.tvHorizontalItemLayoutTitle);
            btnHorizontalItemLayoutViewAll = itemView.findViewById(R.id.btnHorizontalItemLayoutViewAll);
            rvHorizontalItemHolder = itemView.findViewById(R.id.rvHorizontalItemHolder);
            rvHorizontalItemHolder.setRecycledViewPool(recycledViewPool);

        }

        private void setHorizontalLayout(List<HorizontalScrollItemModel> horizontalScrollItems, String itemTitle){

            tvHorizontalItemLayoutTitle.setText(itemTitle);

            if(horizontalScrollItems.size() > 8){
                btnHorizontalItemLayoutViewAll.setVisibility(View.VISIBLE);
                btnHorizontalItemLayoutViewAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), ViewAllActivity.class);
                        intent.putExtra(Constants.HOME_FRAG_VIEW_ALL_KEY, Constants.HORIZONTAL_VIEW_ALL);
                        itemView.getContext().startActivity(intent);
                    }
                });
            }
            else btnHorizontalItemLayoutViewAll.setVisibility(View.INVISIBLE);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvHorizontalItemHolder.setLayoutManager(linearLayoutManager);
            rvHorizontalItemHolder.setHasFixedSize(true);
            HorizontalScrollItemAdapter horizontalScrollItemAdapter = new HorizontalScrollItemAdapter(horizontalScrollItems);
            rvHorizontalItemHolder.setAdapter(horizontalScrollItemAdapter);
        }
    }

    public class GridItemViewHolder extends RecyclerView.ViewHolder{
        private TextView tvGridItemTitle;
        private Button btnGridItemViewAll;
        private GridLayout glGridItemHolder;

        public GridItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGridItemTitle = itemView.findViewById(R.id.tvGridItemTitle);
            btnGridItemViewAll = itemView.findViewById(R.id.btnGridItemViewAll);
            glGridItemHolder = itemView.findViewById(R.id.glGridItemHolder);

        }

        private void setGridItems(List<HorizontalScrollItemModel> gridItems, String itemTitle){
            tvGridItemTitle.setText(itemTitle);

            for(int i = 0; i<4; i++){
                ImageView productImage = glGridItemHolder.getChildAt(i).findViewById(R.id.ivHorizontalScrollItemImage);
                TextView productTitle = glGridItemHolder.getChildAt(i).findViewById(R.id.tvHorizontalScrollItemTitle);
                TextView productSubTitle = glGridItemHolder.getChildAt(i).findViewById(R.id.tvHorizontalScrollItemSubTitle);
                TextView productPrice = glGridItemHolder.getChildAt(i).findViewById(R.id.tvHorizontalScrollItemPrice);

                productImage.setImageResource(gridItems.get(i).getHorizontalScrollItemImageLink());
                productTitle.setText(gridItems.get(i).getHorizontalScrollItemTitle());
                productSubTitle.setText(gridItems.get(i).getHorizontalScrollItemSubTitle());
                productPrice.setText(gridItems.get(i).getHorizontalScrollItemPrice());

                glGridItemHolder.getChildAt(i).setBackgroundColor(Color.parseColor("#ffffff"));

                glGridItemHolder.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                        itemView.getContext().startActivity(intent);
                    }
                });
            }

            if(gridItems.size()>4) {
                btnGridItemViewAll.setVisibility(View.VISIBLE);
                btnGridItemViewAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), ViewAllActivity.class);
                        intent.putExtra(Constants.HOME_FRAG_VIEW_ALL_KEY, Constants.GRID_VIEW_ALL);
                        itemView.getContext().startActivity(intent);
                    }
                });
            }
            else btnGridItemViewAll.setVisibility(View.INVISIBLE);

        }
    }

}

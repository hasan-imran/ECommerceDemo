package com.example.ecommercedemo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.ecommercedemo.fragments.navigation_items.home.HomeFragment;
import com.example.ecommercedemo.fragments.navigation_items.mycart.MyCartFragment;
import com.example.ecommercedemo.fragments.navigation_items.myorders.MyOrdersFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final int NAV_HOME_INDEX = 0;
    public static final int NAV_MY_ORDERS_INDEX = 1;
    public static final int NAV_MY_REWARDS_INDEX = 2;
    public static final int NAV_MY_CART_INDEX = 3;
    public static final int NAV_MY_WISHLIST_INDEX = 4;
    public static final int NAV_MY_ACCOUNT_INDEX = 5;
    public static final int NAV_SIGN_OUT_INDEX = 6;

    public static final int HOME_FRAGMENT = 0;
    public static final int CART_FRAGMENT = 1;
    public static final int MY_ORDERS_FRAGMENT = 2;

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout flMainLayout;
    private NavigationView navigationView;
    private ImageView ivAppBarLogo;


    private DrawerLayout drawer;

    private static int currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayShowTitleEnabled(false);


        flMainLayout = findViewById(R.id.flMainLayout);


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(NAV_HOME_INDEX).setChecked(true);

        ivAppBarLogo = findViewById(R.id.ivAppBarLogo);
        //ivAppBarLogo.setVisibility(View.VISIBLE);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();

        setFragment(new HomeFragment(), HOME_FRAGMENT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentFragment == HOME_FRAGMENT){
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int clickedId = item.getItemId();

        if(clickedId == R.id.action_cart){
            goToFragment("My Cart", new MyCartFragment(), CART_FRAGMENT);
            return true;
        }
        else if(clickedId == R.id.action_notifications){

        }
        else if(clickedId == R.id.action_search){

        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int clickedId = item.getItemId();
        if(clickedId == R.id.nav_my_orders){
            goToFragment("My Orders", new MyOrdersFragment(), MY_ORDERS_FRAGMENT);
            //drawer.closeDrawers();
        }
        else if(clickedId == R.id.nav_my_wishlist){

        }
        else if(clickedId == R.id.nav_my_rewards){

        }
        else if(clickedId == R.id.nav_my_cart){
            goToFragment("My Cart", new MyCartFragment(), CART_FRAGMENT);
            //drawer.closeDrawers();
        }
        else if(clickedId == R.id.nav_my_account){

        }
        else if(clickedId == R.id.nav_sign_out){

        }
        else if(clickedId == R.id.nav_home){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            ivAppBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(), HOME_FRAGMENT);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void goToFragment(String title, Fragment fragment, int fragmentNo) {
        ivAppBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment, fragmentNo);
        if(fragmentNo == CART_FRAGMENT){
            navigationView.getMenu().getItem(NAV_MY_CART_INDEX).setChecked(true);
        }
    }

    private void  setFragment(Fragment fragment, int fragmentNo){
        currentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(flMainLayout.getId(), fragment);
        fragmentTransaction.commit();
    }


}
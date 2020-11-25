package com.example.ecommercedemo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.ecommercedemo.fragments.navigation_items.home.HomeFragment;
import com.example.ecommercedemo.fragments.navigation_items.myaccount.MyAccountFragment;
import com.example.ecommercedemo.fragments.navigation_items.mycart.MyCartFragment;
import com.example.ecommercedemo.fragments.navigation_items.myorders.MyOrdersFragment;
import com.example.ecommercedemo.fragments.navigation_items.mywishlist.MyWishlistFragment;
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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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
    public static final int MY_WISHLIST_FRAGMENT = 3;
    public static final int MY_ACCOUNT_FRAGMENT = 4;

    public static boolean showCart = false;

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout flMainLayout;
    private NavigationView navigationView;
    private ImageView ivAppBarLogo;

    private DrawerLayout drawer;

    private int currentFragment = -1;

    @SuppressLint("WrongConstant")
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



        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();

        if(showCart){
            drawer.setDrawerLockMode(1);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            goToFragment("My Cart", new MyCartFragment(), -2);
        }
        else{
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            setFragment(new HomeFragment(), HOME_FRAGMENT);
        }
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
            Dialog signInDialog = new Dialog(MainActivity.this);
            signInDialog.setContentView(R.layout.dialog_sign_in);
            signInDialog.setCancelable(true);
            signInDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);

            Button btnDialogSignIn = signInDialog.findViewById(R.id.btnDialogSignIn);
            Button btnDialogSignUp = signInDialog.findViewById(R.id.btnDialogSignUp);

            btnDialogSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInDialog.dismiss();
                    RegisterActivity.setSignUpFragment = false;
                    startActivity(intent);
                }
            });
            btnDialogSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInDialog.dismiss();
                    RegisterActivity.setSignUpFragment = true;
                    startActivity(intent);
                }
            });
            signInDialog.show();

            //goToFragment("My Cart", new MyCartFragment(), CART_FRAGMENT);
            return true;
        }
        else if(clickedId == R.id.action_notifications){

        }
        else if(clickedId == R.id.action_search){

        }
        else if(clickedId == android.R.id.home){
            if(showCart){
                onBackPressed();
                return true;
            }
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
            goToFragment("My WishList", new MyWishlistFragment(), MY_WISHLIST_FRAGMENT);
        }
        else if(clickedId == R.id.nav_my_rewards){

        }
        else if(clickedId == R.id.nav_my_cart){
            goToFragment("My Cart", new MyCartFragment(), CART_FRAGMENT);
            //drawer.closeDrawers();
        }
        else if(clickedId == R.id.nav_my_account){
            goToFragment("My Account", new MyAccountFragment(), MY_ACCOUNT_FRAGMENT);
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
        else if(fragmentNo == MY_WISHLIST_FRAGMENT){
            navigationView.getMenu().getItem(NAV_MY_WISHLIST_INDEX).setChecked(true);
        }
        else if(fragmentNo == MY_ACCOUNT_FRAGMENT){
            navigationView.getMenu().getItem(NAV_MY_ACCOUNT_INDEX).setChecked(true);
        }
    }

    private void  setFragment(Fragment fragment, int fragmentNo){
        currentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(flMainLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            if(currentFragment == HOME_FRAGMENT) {
                currentFragment = -1;
                super.onBackPressed();
            }
            else{

                if(showCart){
                    showCart = false;
                    //onBackPressed();
                    finish();
                }
                else {
                    getSupportActionBar().setDisplayShowTitleEnabled(false);
                    ivAppBarLogo.setVisibility(View.VISIBLE);
                    invalidateOptionsMenu();
                    setFragment(new HomeFragment(), HOME_FRAGMENT);
                    navigationView.getMenu().getItem(NAV_HOME_INDEX).setChecked(true);
                }
            }
        }
    }
}
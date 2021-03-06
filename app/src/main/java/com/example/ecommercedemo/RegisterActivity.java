package com.example.ecommercedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ecommercedemo.fragments.signinsignup.SignInFragment;
import com.example.ecommercedemo.fragments.signinsignup.SignUpFragment;

public class RegisterActivity extends AppCompatActivity {

    private FrameLayout flRegister;
    public static boolean setSignUpFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        flRegister = findViewById(R.id.flRegister);

        if(setSignUpFragment){
            setSignUpFragment = false;
            setFragment(new SignUpFragment());
        }
        else{
            setFragment(new SignInFragment());
        }
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(flRegister.getId(), fragment);
        fragmentTransaction.commit();
    }
}
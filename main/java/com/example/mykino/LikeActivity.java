package com.example.mykino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class LikeActivity extends BaseActivity {


    Button buttonViewPager, buttonViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        InitBottomView(R.id.like);

        buttonViewPager = (Button) findViewById(R.id.buttonViewPager);
        buttonViewPager.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
        });


        buttonViewPager2 = (Button) findViewById(R.id.buttonViewPager2);
        buttonViewPager2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ViewPager2.class));
        });



    }
}
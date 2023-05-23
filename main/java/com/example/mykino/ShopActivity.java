package com.example.mykino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ShopActivity extends BaseActivity {

    private int count = 0;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        InitBottomView(R.id.shop);


        TextView textView = findViewById(R.id.textShop);
        Button btnCountPlus = findViewById(R.id.buttonPlusCount);
        btnCountPlus.setOnClickListener(view -> {
            count++;
            String str = Integer.toString(count);
            textView.setText(str);
        });

        if (savedInstanceState!= null){
            count = savedInstanceState.getInt("count");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
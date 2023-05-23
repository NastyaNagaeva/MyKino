package com.example.mykino;

import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BaseActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private Boolean registeredUser = false;

    protected void InitBottomView(Integer itemToSelect) {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(itemToSelect);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == itemToSelect)
                return true;
            switch (item.getItemId()) {

                case R.id.tape:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.like:
                    startActivity(new Intent(getApplicationContext(), LikeActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.shop:
                    startActivity(new Intent(getApplicationContext(), ShopActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.person:

                    if (registeredUser) {
                        startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    }
                    else {
                        startActivity(new Intent(getApplicationContext(), PersonActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    }
            }
            return false;
        });
    }


    public void setRegisteredUser(Boolean registeredUser){
        this.registeredUser = registeredUser;
    }

}

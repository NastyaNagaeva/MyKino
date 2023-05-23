package com.example.mykino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AccountActivity extends BaseActivity {

    public static final String USERNAME = "NAME";

    private TextView nameText;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        InitBottomView(R.id.person);

        nameText = findViewById(R.id.usernameActivity);
        Intent intent = getIntent();
        username = intent.getStringExtra(USERNAME);
        nameText.setText(username);

    }
}
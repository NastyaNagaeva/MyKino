package com.example.mykino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonActivity extends BaseActivity {

    Button buttonRegistration, buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        InitBottomView(R.id.person);


        Button buttonRegistration = findViewById(R.id.buttonRegistration);
        buttonRegistration.setOnClickListener(view ->
        {
            startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
        });


        Button buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(view ->
        {
            startActivity(new Intent(getApplicationContext(), SignIn.class));
        });





    }

}
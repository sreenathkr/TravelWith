package com.reshma.travelwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class forgotPassword extends AppCompatActivity {
    ImageView nextButton;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        nextButton = (ImageView) findViewById(R.id.imageView3);
        backButton = (ImageView) findViewById(R.id.imageView5);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), forgotPasswordEmail.class);
                startActivityForResult(myIntent, 0);

            }

        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), signInPage.class);
                startActivityForResult(myIntent, 0);

            }

        });
    }
}





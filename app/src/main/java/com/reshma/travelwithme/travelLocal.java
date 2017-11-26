package com.reshma.travelwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class travelLocal extends AppCompatActivity {
    ImageView registrationbtn;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_local);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        registrationbtn = (ImageView) findViewById(R.id.imageView);
        back = (ImageView) findViewById(R.id.imageView10);
        registrationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), registrationPage.class);
                startActivityForResult(myIntent, 0);
            }

        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), signInPage.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}

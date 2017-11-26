package com.reshma.travelwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class registrationPage extends AppCompatActivity {
    ImageView back;
    Button verifyemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        back = (ImageView) findViewById(R.id.imageView9);
        verifyemail = (Button) findViewById(R.id.registerbtn);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        verifyemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), verifyEmailScreen.class);
                startActivity(intent);
                //Toast.makeText(Travel.this,"yoigfyffftjy",Toast.LENGTH_LONG).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), travelLocal.class);
                startActivity(intent);
                //Toast.makeText(Travel.this,"yoigfyffftjy",Toast.LENGTH_LONG).show();
            }
        });
    }
}

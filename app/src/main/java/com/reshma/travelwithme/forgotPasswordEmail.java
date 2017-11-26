package com.reshma.travelwithme;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class forgotPasswordEmail extends AppCompatActivity {
    TextView emailsent;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_email);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        emailsent = (TextView) findViewById(R.id.textView9);
        backButton = (ImageView) findViewById(R.id.imageView7);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Consolas.ttf");
        emailsent.setTypeface(typeface);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), forgotPassword.class);
                startActivityForResult(myIntent, 0);

            }

        });
    }
}

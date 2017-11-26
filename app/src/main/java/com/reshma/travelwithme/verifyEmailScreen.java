package com.reshma.travelwithme;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class verifyEmailScreen extends AppCompatActivity {
    TextView congrats;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        congrats = (TextView) findViewById(R.id.textView9);
        back = (ImageView) findViewById(R.id.imageView7);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Consolas.ttf");
        congrats.setTypeface(typeface);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), registrationPage.class);
                startActivityForResult(myIntent, 0);

            }

        });
    }
}

package com.reshma.travelwithme;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class emailSent extends AppCompatActivity {
    TextView emailsent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sent);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        emailsent = (TextView) findViewById(R.id.textView9);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Consolas.ttf");
        emailsent.setTypeface(typeface);
    }
}

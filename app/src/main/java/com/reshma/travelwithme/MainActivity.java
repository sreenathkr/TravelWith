package com.reshma.travelwithme;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {
    EditText phoneNumber;
    EditText countrycode;
    TextView tagline;
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tx = (TextView) findViewById(R.id.textView3);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        tagline = (TextView) findViewById(R.id.textView4);
        phoneNumber = (EditText) findViewById(R.id.editText);
        countrycode = (EditText) findViewById(R.id.editText2);
        // for importing a new font pristina
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Pristina.ttf");
        tx.setTypeface(typeface);
        // for hiding the action bar in the activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        // for changing the color of progress view in the lower android versions
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Call some material design APIs here
            mProgressBar.getIndeterminateDrawable().setColorFilter(getResources()
                    .getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        }
        // for changing the color of the status bar in the kitkat versions, added a new library
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
        tintManager.setStatusBarTintEnabled(true);
        // tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
        // to detect the sim country
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        final String countryCode = tm.getSimCountryIso();
        Log.e("country", countryCode);
        //the tagline,phone number and the country code views are not there
        tagline.setVisibility(View.GONE);
        phoneNumber.setVisibility(View.GONE);
        countrycode.setVisibility(View.GONE);
        //making the views visible after a delay
        phoneNumber.postDelayed(new Runnable() {
            public void run() {
                phoneNumber.setVisibility(View.VISIBLE);
                countrycode.setVisibility(View.VISIBLE);
                tagline.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        }, 3000);
        //changing the underline color of the edit text fields
        phoneNumber.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        countrycode.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);

        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), registerMobile.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}

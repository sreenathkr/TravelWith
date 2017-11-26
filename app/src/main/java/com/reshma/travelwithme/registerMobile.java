package com.reshma.travelwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class registerMobile extends AppCompatActivity {
    ImageView imagenextbutton;
    EditText phonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mobile);
        imagenextbutton = (ImageView) findViewById(R.id.imageView2);
        phonenum = (EditText) findViewById(R.id.editText4);
        // for hiding the action bar in the activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        imagenextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(phonenum.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "please enter a phone number", Toast.LENGTH_SHORT).show();
                } else {
                    Intent myIntent = new Intent(v.getContext(), otpmobile.class);
                    myIntent.putExtra("phonenumber", phonenum.getText().toString());
                    startActivityForResult(myIntent, 0);
                }
            }

        });
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }
}

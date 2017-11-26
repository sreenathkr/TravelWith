package com.reshma.travelwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class signInPage extends AppCompatActivity {
    Button forgotButton;
    Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        
        forgotButton = (Button) findViewById(R.id.button6);
        registration = (Button) findViewById(R.id.button7);

        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), forgotPassword.class);
                startActivityForResult(myIntent, 0);
            }

        });

    }

    public void registration(View v) {
        //Toast.makeText(getApplicationContext(),"code sent to the number",Toast.LENGTH_SHORT).show();
        Intent myIntent1 = new Intent(v.getContext(), travelLocal.class);
        startActivity(myIntent1);
    }


}


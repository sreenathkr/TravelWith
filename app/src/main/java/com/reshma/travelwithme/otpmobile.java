package com.reshma.travelwithme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class otpmobile extends AppCompatActivity {
    Button button;
    EditText receivedCode;
    FirebaseAuth auth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    String verificationCode;

    Context c;
    ImageView backButton;

    @Override
    protected void onStart() {
        super.onStart();
        String number = getIntent().getStringExtra("phonenumber");
        Log.e("phonenum", number);
        backButton = (ImageView) findViewById(R.id.imageView8);

        PhoneAuthProvider.getInstance().verifyPhoneNumber(number, 60, TimeUnit.SECONDS, this, mCallback);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpmobile);
        button = (Button) findViewById(R.id.button2);
        receivedCode = (EditText) findViewById(R.id.editText5);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        auth = FirebaseAuth.getInstance();


        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//Log.d(TAG,"onVerificationCompleted:"+phoneAuthCredential);
                signInWithPhone(phoneAuthCredential);
            }


            @Override
            public void onVerificationFailed(FirebaseException e) {
                //Log.w(TAG,"onVerificationFailed:",e);
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                //Log.d(TAG,"onCodeSent:" + s);
                verificationCode = s;
                Toast.makeText(getApplicationContext(), "code sent to the number", Toast.LENGTH_SHORT).show();
            }
        };
// Now set this value to EditText


    }

    //   public void send(View v)
//   {
//    String number = getIntent().getStringExtra("phonenumber");
//        Log.e("phonenum",number);
//
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60,TimeUnit.SECONDS,this,mCallback);
//   }
    public void back(View v) {
        Intent myIntent = new Intent(v.getContext(), registerMobile.class);
        startActivityForResult(myIntent, 0);
    }

    public void verify(View v) {
        String input_code = receivedCode.getText().toString();
        if (TextUtils.isEmpty(input_code)) {
            Toast.makeText(getApplicationContext(), "please enter the otp received", Toast.LENGTH_SHORT).show();
        } else {
            //Log.e("phonenum",input_code);
            verifyPhoneNumber(verificationCode, input_code);
        }
    }

    public void verifyPhoneNumber(String verificationCode, String input_code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, input_code);
        Log.e("verphonenum", verificationCode);
        signInWithPhone(credential);
    }

    public void signInWithPhone(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                        @Override
                                                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                                                            if (task.isSuccessful()) {
                                                                                FirebaseUser user = task.getResult().getUser();
                                                                                Toast.makeText(getApplicationContext(), "User Signed in Successfully", Toast.LENGTH_SHORT).show();
                                                                                Intent myIntent = new Intent(otpmobile.this, signInPage.class);
                                                                                startActivityForResult(myIntent, 0);
                                                                            } else {
                                                                                Toast.makeText(getApplicationContext(), "otp incorrect", Toast.LENGTH_SHORT).show();
                                                                            }
                                                                        }
                                                                    }
        );
    }

}

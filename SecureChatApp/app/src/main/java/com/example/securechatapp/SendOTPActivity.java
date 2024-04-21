package com.example.securechatapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SendOTPActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String mVerificationId;
    PhoneAuthProvider.ForceResendingToken mResendToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otpactivity);

        final EditText inputMobile = findViewById(R.id.inputMobile);
        Button buttonGetOTP = findViewById(R.id.buttonGetOtp);


        buttonGetOTP.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(SendOTPActivity.this , "Enter Mobile",Toast.LENGTH_SHORT).show();
                    return;
                }

                Log.v("PhoneNumber",inputMobile.getText().toString());

                PhoneAuthOptions  options =
                        PhoneAuthOptions.newBuilder(mAuth)
                                .setPhoneNumber("+91 "+inputMobile.getText().toString())
                                .setTimeout(60L, TimeUnit.SECONDS)
                                .setActivity(SendOTPActivity.this).setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        Toast.makeText(SendOTPActivity.this,"OTP Verification done" , Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        Toast.makeText(SendOTPActivity.this,"OTP Verification failed" , Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String verificationId,
                                                           @NonNull PhoneAuthProvider.ForceResendingToken token) {

                                        mVerificationId = verificationId;
                                        mResendToken = token;
                                        Intent intent = new Intent(getApplicationContext(), com.example.securechatapp.VerifyOTPActivity.class);
                                        intent.putExtra("mobile",inputMobile.getText().toString());
                                        intent.putExtra("verificationID",mVerificationId);
                                        intent.putExtra("resendToken",mResendToken);
                                        startActivity(intent);
                                    }

                                }).build();

                PhoneAuthProvider.verifyPhoneNumber(options);
            }
        }));
    }
}
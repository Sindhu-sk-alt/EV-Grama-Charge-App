package com.example.evgramacharge;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    Button signupBtn;
    TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupBtn = findViewById(R.id.signupBtn);
        loginText = findViewById(R.id.loginText);

        // SIGN UP button -> Login page
        signupBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    SignupActivity.this,
                    LoginActivity.class);

            startActivity(intent);
            finish();
        });

        // Already have account? Login
        loginText.setOnClickListener(v -> {

            Intent intent = new Intent(
                    SignupActivity.this,
                    LoginActivity.class);

            startActivity(intent);
            finish();
        });
    }
}
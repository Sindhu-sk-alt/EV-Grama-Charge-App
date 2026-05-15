package com.example.evgramacharge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    EditText emailEditText, passwordEditText;
    TextView signupText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.loginBtn);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signupText = findViewById(R.id.signupText);

        // Sign Up text -> Signup Page
        signupText.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    SignupActivity.class);

            startActivity(intent);
        });

        // Login button -> Main Page
        loginBtn.setOnClickListener(v -> {

            String email =
                    emailEditText.getText().toString().trim();

            String password =
                    passwordEditText.getText().toString().trim();

            // Gmail validation
            if (!Patterns.EMAIL_ADDRESS
                    .matcher(email).matches()
                    || !email.endsWith("@gmail.com")) {

                Toast.makeText(
                        LoginActivity.this,
                        "Enter valid Gmail",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Password validation
            String passwordPattern =
                    "^(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*\\d).{6,}$";

            if (!password.matches(passwordPattern)) {

                Toast.makeText(
                        LoginActivity.this,
                        "Password must contain Capital letter, @ symbol and number",
                        Toast.LENGTH_LONG
                ).show();

                return;
            }

            // Go to Main Page
            Intent intent = new Intent(
                    LoginActivity.this,
                    MainActivity.class);

            startActivity(intent);
            finish();
        });
    }
}
package com.example.evgramacharge;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText, phoneEditText;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameEditText =
                findViewById(R.id.nameEditText);

        emailEditText =
                findViewById(R.id.emailEditText);

        phoneEditText =
                findViewById(R.id.phoneEditText);

        saveBtn =
                findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(v -> {

            String name =
                    nameEditText.getText()
                            .toString().trim();

            String email =
                    emailEditText.getText()
                            .toString().trim();

            String phone =
                    phoneEditText.getText()
                            .toString().trim();

            // Name validation
            if (name.isEmpty()) {
                nameEditText.setError(
                        "Enter Name");
                return;
            }

            // Email validation
            if (email.isEmpty()) {
                emailEditText.setError(
                        "Enter Email");
                return;
            }

            if (!Patterns.EMAIL_ADDRESS
                    .matcher(email)
                    .matches()) {

                emailEditText.setError(
                        "Enter valid Email");
                return;
            }

            // Phone validation
            if (phone.isEmpty()) {
                phoneEditText.setError(
                        "Enter Phone Number");
                return;
            }

            if (phone.length() != 10) {
                phoneEditText.setError(
                        "Phone number must be exactly 10 digits");
                return;
            }

            Toast.makeText(
                    ProfileActivity.this,
                    "Profile Saved Successfully",
                    Toast.LENGTH_SHORT
            ).show();

            finish(); // Back to Main Page
        });
    }
}
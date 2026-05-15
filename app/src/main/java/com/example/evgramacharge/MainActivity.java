package com.example.evgramacharge;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button bookingBtn, stationBtn, profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookingBtn = findViewById(R.id.bookingBtn);
        stationBtn = findViewById(R.id.stationBtn);
        profileBtn = findViewById(R.id.profileBtn);

        // Book Charging Slot
        bookingBtn.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    BookingActivity.class
            );
            startActivity(intent);
        });

        // Nearby Stations
        stationBtn.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    StationActivity.class
            );
            startActivity(intent);
        });

        // Profile
        profileBtn.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ProfileActivity.class
            );
            startActivity(intent);
        });
    }
}
package com.example.evgramacharge;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StationActivity extends AppCompatActivity {

    Spinner locationSpinner;
    Button selectBtn;

    String[] locations = {
            "Kolar EV Station",
            "Bangalore EV Station",
            "Bus Stand EV Station",
            "Village Center EV Station",
            "MG Road EV Station"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);

        locationSpinner =
                findViewById(R.id.locationSpinner);

        selectBtn =
                findViewById(R.id.selectBtn);

        // Add locations to spinner
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        locations
                );

        locationSpinner.setAdapter(adapter);

        // Select location button
        selectBtn.setOnClickListener(v -> {

            String selectedLocation =
                    locationSpinner
                            .getSelectedItem()
                            .toString();

            Toast.makeText(
                    StationActivity.this,
                    "Selected: " + selectedLocation,
                    Toast.LENGTH_SHORT
            ).show();

            finish(); // Go back to Main Page
        });
    }
}
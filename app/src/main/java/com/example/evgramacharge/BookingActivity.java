package com.example.evgramacharge;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    EditText dateEditText, fromTimeEditText, toTimeEditText;
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        dateEditText = findViewById(R.id.dateEditText);
        fromTimeEditText = findViewById(R.id.fromTimeEditText);
        toTimeEditText = findViewById(R.id.toTimeEditText);
        confirmBtn = findViewById(R.id.confirmBtn);

        // DATE PICKER
        dateEditText.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();

            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(
                            BookingActivity.this,
                            (view, year, month, dayOfMonth) ->
                                    dateEditText.setText(
                                            dayOfMonth + "/" +
                                                    (month + 1) + "/" +
                                                    year
                                    ),
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH)
                    );

            datePickerDialog.show();
        });

        // FROM TIME PICKER (AM/PM)
        fromTimeEditText.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();

            TimePickerDialog timePickerDialog =
                    new TimePickerDialog(
                            BookingActivity.this,
                            (view, hourOfDay, minute) -> {

                                String amPm =
                                        (hourOfDay >= 12) ? "PM" : "AM";

                                int hour =
                                        (hourOfDay > 12)
                                                ? hourOfDay - 12
                                                : hourOfDay;

                                if (hour == 0) {
                                    hour = 12;
                                }

                                fromTimeEditText.setText(
                                        hour + ":" + minute + " " + amPm
                                );
                            },
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            false
                    );

            timePickerDialog.show();
        });

        // TO TIME PICKER (AM/PM)
        toTimeEditText.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();

            TimePickerDialog timePickerDialog =
                    new TimePickerDialog(
                            BookingActivity.this,
                            (view, hourOfDay, minute) -> {

                                String amPm =
                                        (hourOfDay >= 12) ? "PM" : "AM";

                                int hour =
                                        (hourOfDay > 12)
                                                ? hourOfDay - 12
                                                : hourOfDay;

                                if (hour == 0) {
                                    hour = 12;
                                }

                                toTimeEditText.setText(
                                        hour + ":" + minute + " " + amPm
                                );
                            },
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            false
                    );

            timePickerDialog.show();
        });

        // CONFIRM BOOKING
        confirmBtn.setOnClickListener(v -> {

            String date =
                    dateEditText.getText().toString();

            String fromTime =
                    fromTimeEditText.getText().toString();

            String toTime =
                    toTimeEditText.getText().toString();

            if (date.isEmpty()) {
                Toast.makeText(
                        BookingActivity.this,
                        "Please select date",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            if (fromTime.isEmpty()) {
                Toast.makeText(
                        BookingActivity.this,
                        "Please select from time",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            if (toTime.isEmpty()) {
                Toast.makeText(
                        BookingActivity.this,
                        "Please select to time",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            Toast.makeText(
                    BookingActivity.this,
                    "Charging Slot Booked Successfully",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent =
                    new Intent(
                            BookingActivity.this,
                            MainActivity.class
                    );

            startActivity(intent);
            finish();
        });
    }
}
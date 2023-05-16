package sg.edu.rp.c346.id22035660.l04reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnReset;
    Button btnSubmit;
    TextView tvName;
    TextView tvContact;
    TextView tvPeople;
    CheckBox cbEnabled;
    CheckBox cbEnabled2;
    TextView tvdisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReset = findViewById(R.id.button);
        btnSubmit = findViewById(R.id.button2);
        tvName = findViewById(R.id.editTextName);
        tvContact = findViewById(R.id.editTextContact);
        tvPeople = findViewById(R.id.editTextPeople);
        cbEnabled = findViewById(R.id.checkBox);
        cbEnabled2= findViewById(R.id.checkBox2);
        tvdisplay = findViewById(R.id.textView2);

        tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tp.isEnabled()){
                    int hour =tp.getHour();
                    int minute = tp.getMinute();
                    btnSubmit.setText("Time is " + hour + ":" + minute);
                }
            }
        });

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dp.isEnabled()){
                    int dayMonth = dp.getDayOfMonth();
                    int month = dp.getMonth() + 1;
                    int year = dp.getYear();
                    btnSubmit.setText("Date is " + dayMonth + "/" + month + "/" + year);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnReset.isEnabled()){
                    tp.setHour(19);
                    tp.setMinute(30);
                    dp.updateDate(2020,05,01);
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tvName.getText().toString();
                String contact = tvContact.getText().toString();
                String people = tvPeople.getText().toString();

                String smokingArea = "";
                if (cbEnabled.isChecked()) {
                    smokingArea = "Smoking Area";
                } else if (cbEnabled2.isChecked()) {
                    smokingArea = "Non-Smoking Area";
                }

                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();

                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                String dateTime = day + "/" + month + "/" + year + " " + hour + ":" + minute;

                String message = "Name: " + name + "\n" +
                        "Contact: " + contact + "\n" +
                        "Number of People: " + people + "\n" +
                        "Smoking Area: " + smokingArea + "\n" +
                        "Date and Time: " + dateTime;

                tvdisplay.setText(message);
                Toast.makeText(MainActivity.this, "Reservation Confirmed", Toast.LENGTH_SHORT).show();
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset all inputs and set default date and time
                tvName.setText("");
                tvContact.setText("");
                tvPeople.setText("");
                cbEnabled.setChecked(false);
                cbEnabled.setChecked(false);
                dp.init(2020, Calendar.JUNE, 1, null);
                tp.setHour(19);
                tp.setMinute(30);
                tvdisplay.setText("");
                Toast.makeText(MainActivity.this, "Inputs Cleared", Toast.LENGTH_SHORT).show();
            }
        });

        {
    }

    }
}
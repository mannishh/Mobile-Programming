package com.example.app;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RadioButton1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

// on below line we are adding check change listener for our radio group.
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

// on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);

// on below line we are displaying a toast message.
                Toast.makeText(RadioButton1.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
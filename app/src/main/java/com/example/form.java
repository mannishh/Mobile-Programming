package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class form extends AppCompatActivity {

    private Spinner countrySpinner;
    private EditText nameEditText, emailEditText, addressEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton;
    private CheckBox javaCheckBox, pythonCheckBox, webDevCheckBox, reactCheckBox;
    private Button submitButton;
    private TextView displayDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize UI components
        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        addressEditText = findViewById(R.id.address);
        genderRadioGroup = findViewById(R.id.radioGroup);
        maleRadioButton = findViewById(R.id.male);
        femaleRadioButton = findViewById(R.id.female);
        javaCheckBox = findViewById(R.id.java);
        pythonCheckBox = findViewById(R.id.python);
        webDevCheckBox = findViewById(R.id.webDev);
        reactCheckBox = findViewById(R.id.react);
        countrySpinner = findViewById(R.id.spinner);
        submitButton = findViewById(R.id.button);
        displayDataTextView = findViewById(R.id.displayData);

        // Populate the spinner with data
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);

        // Handle spinner item selection
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Do nothing
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Handle button click
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String gender = ((RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId())).getText().toString();
                String selectedCourses = getSelectedCourses();
                String country = countrySpinner.getSelectedItem().toString();

                // Display the collected data
                String displayText = "Name: " + name + "\nEmail: " + email + "\nAddress: " + address + "\nGender: " + gender + "\nCourses: " + selectedCourses + "\nCountry: " + country;
                displayDataTextView.setText(displayText);
                displayDataTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    private String getSelectedCourses() {
        StringBuilder selectedCourses = new StringBuilder();
        if (javaCheckBox.isChecked()) {
            selectedCourses.append("Java,");
        }
        if (pythonCheckBox.isChecked()) {
            selectedCourses.append("Python,");
        }
        if (webDevCheckBox.isChecked()) {
            selectedCourses.append("Web Development,");
        }
        if (reactCheckBox.isChecked()) {
            selectedCourses.append("React, ");
        }
        return selectedCourses.toString().trim();
    }
}

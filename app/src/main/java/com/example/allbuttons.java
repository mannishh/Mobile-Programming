package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class allbuttons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_allbuttons);
        Button form = findViewById(R.id.form11);
        Button database1 = findViewById(R.id.database);

        // Set an OnClickListener for the button
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new Activity
                Intent intent = new Intent(allbuttons.this, form2.class);
                startActivity(intent);  // Start the new activity
            }
        });

        database1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new Activity
                Intent intent = new Intent(allbuttons.this, Database.class);
                startActivity(intent);  // Start the new activity
            }
        });

    }

}


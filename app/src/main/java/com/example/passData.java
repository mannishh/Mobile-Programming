package com.example.app;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class passData extends AppCompatActivity {

    private static final int GET_DATA_REQUEST_CODE = 1;
    private TextView txtMessage;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_data);
        Log.d("Life cycle: ", "Created");

        Button btn = findViewById(R.id.button);
        txtMessage = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String userInput = editText.getText().toString(); // Get user input
                Intent i = new Intent(passData.this, getData.class);
                i.putExtra("message", userInput);
                startActivityForResult(i, GET_DATA_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_DATA_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String returnedData = data.getStringExtra("returnedData");
                if (returnedData != null) {
                    txtMessage.setText(returnedData); // Update TextView with returned data
                }
            }
        }
    }
}





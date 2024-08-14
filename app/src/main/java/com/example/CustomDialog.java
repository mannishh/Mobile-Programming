package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CustomDialog extends AppCompatActivity {

    Button btnDialog;
    Button btnCalculate;
    EditText editFirst, editSecond;
    TextView txtResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogbox);



        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }


        });

    }

    @SuppressLint("MissingInflatedId")
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomDialog.this);
        builder.setTitle("Calculate sum");
        builder.setCancelable(true);

        LayoutInflater inflater = getLayoutInfalter();
        View view = inflater.inflate(R.layout.activity_mennu, null);
        builder.setView(view);

        editFirst = view.findViewById(R.id.edtFirst);
        editSecond = view.findViewById(R.id.edtSecond);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        txtResult = view.findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int first, second, result;
                first = Integer.parseInt(editFirst.getText().toString());
                second = Integer.parseInt(editSecond.getText().toString());
                result = first + second;
                txtResult.setText(("Result =" + result));
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private LayoutInflater getLayoutInfalter() {
        return null;
    }
}


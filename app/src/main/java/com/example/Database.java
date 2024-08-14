package com.example.app;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Database extends AppCompatActivity {
    EditText edtId, edtName, edtAddress;
    Button btnInsert, btnSelect, btnUpdate, btnDelete;
    TextView txtData;
    Db_Helper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        // Creating object of MyDbHelper class
        myDbHelper = new Db_Helper(this);

        edtId = findViewById(R.id.id);
        edtName = findViewById(R.id.name);
        edtAddress = findViewById(R.id.address);
        btnInsert = findViewById(R.id.insert);
        btnUpdate = findViewById(R.id.update);
        btnSelect = findViewById(R.id.view);
        btnDelete = findViewById(R.id.delete);
        txtData = findViewById(R.id.txtData);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edtId.getText().toString());
                String name = edtName.getText().toString();
                String address = edtAddress.getText().toString();
                // Calling insert function
                myDbHelper.insertData(id, name, address);
                Toast.makeText(getApplicationContext(), "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieving data
                Cursor cursor = myDbHelper.selectData();
                StringBuilder data = new StringBuilder();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String address = cursor.getString(2);
                    data.append("Id=").append(id).append("\t Name=").append(name).append("\t Address=").append(address).append("\n");
                }
                // Displaying data in TextView
                txtData.setText(data.toString());
                cursor.close();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtId.getText().toString();
                String name = edtName.getText().toString();
                String address = edtAddress.getText().toString();
                // Calling update function
                myDbHelper.updateData(id, name, address);
                Toast.makeText(getApplicationContext(), "Data Updated Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtId.getText().toString();
                // Calling delete function
                myDbHelper.deleteData(id);
                Toast.makeText(getApplicationContext(), "Data Deleted Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
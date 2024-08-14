package com.example.app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ListView3 extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.mylist1);

        //creating string array
        String[] names =
                {"Ram","Shyam","Hari","Sita","Gita","Manish"};

        //displaying list using ArrayAdapter

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview2,R.id.textView2,names);
        listView.setAdapter(adapter);

        }
    }

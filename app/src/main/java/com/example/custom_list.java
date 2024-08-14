package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class custom_list extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list);

        listView = findViewById(R.id.mylist);

        //creating arrays
        String[] title ={
                "Title 1", "Title2",
                "Title 3", "Title4"};

        String[] description ={
                "This is description1",
                "This is description2",
                "This is description3",
                "This is description4"
        };

        int[] image={
                //Replace with different images
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground

        };

        //passing arrays to constructor of MyListAdapter
        MyListAdapter adapter = new MyListAdapter(this,title,description,image);
        listView.setAdapter(adapter);
    }
}
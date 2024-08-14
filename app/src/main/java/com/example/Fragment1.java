package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app.R;


public class Fragment1 extends AppCompatActivity {

    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_1);
        addListenerOnButton1();
        addListenerOnButton2();
    }

    public void addListenerOnButton1() {
        button1 =(Button) findViewById(R.id.btn1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("fragment 1");
                Fragment fragment1 = new Fragment2();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment,fragment1);
                transaction.commit();
            }
        });
    }

    public void addListenerOnButton2() {
        button2 = findViewById(R.id.btn2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("fragment 2");

                Fragment fragment2 = new Fragment3();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.fragment,fragment2);
                transaction.commit();
            }
        });
    }
}

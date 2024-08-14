package com.example.app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class LifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("Life Cycle test","activity created");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Life Cycle test","starting");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Life Cycle test","Resuming");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("Life Cycle test","Restarting");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Life Cycle test","It is on pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("Life Cycle Test","Stopping");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Life Cycle Test","Destroying");
    }
}
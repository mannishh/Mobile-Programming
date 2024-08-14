package com.example.app;

import android.os.Build;
import android.os.Bundle;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        WindowInsets windowInsets = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            windowInsets = this.getWindow().getDecorView().getRootView().getRootWindowInsets();
        }

        DisplayCutout displayCutout = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            displayCutout = windowInsets.getDisplayCutout();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            int bottom = displayCutout.getSafeInsetBottom();
        }
        setContentView(R.layout.activity_main);

    }
}
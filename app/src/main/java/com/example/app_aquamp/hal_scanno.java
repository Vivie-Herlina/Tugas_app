package com.example.app_aquamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class hal_scanno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hal_scanno);
    }

    public void backk(View v) {
        Intent intent = new Intent(hal_scanno.this, hal_scan.class);
        startActivity(intent);
    }

    public void submit(View v) {
        Intent intent = new Intent (hal_scanno.this, hal_scanyes.class);
        startActivity(intent);
    }

    public void cancel(View v) {
        Intent intent = new Intent (hal_scanno.this, masukhal.class);
        startActivity(intent);
    }

}
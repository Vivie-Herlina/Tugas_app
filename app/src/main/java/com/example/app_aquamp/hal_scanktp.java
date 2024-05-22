package com.example.app_aquamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class hal_scanktp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hal_scanktp);
    }

    public void backk(View v) {
        Intent intent = new Intent(hal_scanktp.this, hal_scanyes.class);
        startActivity(intent);
    }

    public void save(View v) {
        Intent intent = new Intent (hal_scanktp.this, scan_selamat.class);
        startActivity(intent);
    }

    public void cancel(View v) {
        Intent intent = new Intent (hal_scanktp.this, masukhal.class);
        startActivity(intent);
    }

}
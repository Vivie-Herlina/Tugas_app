package com.example.app_aquamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class hal_vaganzardm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hal_vaganzardm);

    }

    public void backk(View v) {
        Intent intent = new Intent(hal_vaganzardm.this, masukhal.class);
        startActivity(intent);
    }

    public void redeem(View v) {
        Intent intent = new Intent(hal_vaganzardm.this, hal_vaganzardm2.class);
        startActivity(intent);
    }
}
package com.example.app_aquamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class hal_scanktp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_scanktp);
    }

    // Metode untuk memulai pemindaian saat tombol diklik
    public void startScan(View view) {
        Intent intent = new Intent(this, scanner_ktp.class);
        startActivity(intent);
    }


    public void backk(View v) {
        Intent intent = new Intent(hal_scanktp.this, hal_ekstravaganza.class);
        startActivity(intent);
    }


    public void cancel(View v) {
        Intent intent = new Intent (hal_scanktp.this, masukhal.class);
        startActivity(intent);
    }

}
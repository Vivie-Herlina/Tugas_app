package com.example.app_aquamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class hal_scan extends AppCompatActivity {
    private ImageButton btnScanBarcode;

    // ActivityResultLauncher untuk memulai ScannerActivity
    private ActivityResultLauncher<Intent> scanBarcodeLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent nextIntent = new Intent(hal_scan.this, hal_scanno.class);
                    startActivity(nextIntent);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_scan);

        btnScanBarcode = findViewById(R.id.btnScanBarcode);

        btnScanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Memulai ScannerActivity dan menunggu hasilnya
                Intent intent = new Intent(hal_scan.this, ScannerActivity.class);
                scanBarcodeLauncher.launch(intent);
            }
        });
    }

    public void backk(View v) {
        Intent intent = new Intent(hal_scan.this, masukhal.class);
        startActivity(intent);
    }

    public void submit(View v) {
        Intent intent = new Intent (hal_scan.this, hal_scanno.class);
        scanBarcodeLauncher.launch(intent);
    }

    public void cancel(View v) {
        Intent intent = new Intent (hal_scan.this, masukhal.class);
        startActivity(intent);
    }
}

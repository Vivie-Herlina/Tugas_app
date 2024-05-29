package com.example.app_aquamp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class hal_scan extends AppCompatActivity {
    private ImageButton btnScanBarcode;

    // ActivityResultLauncher for starting ScannerActivity
    private ActivityResultLauncher<Intent> scanBarcodeLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        int scanCount = data.getIntExtra("scanCount", 0);
                        if (scanCount < 2) {
                            // Barcode scanned less than 2 times, direct to the correct page
                            Intent nextIntent = new Intent(hal_scan.this, hal_scanyes.class);
                            startActivity(nextIntent);
                        } else {
                            // Barcode scanned 2 times or more, direct to the wrong page
                            Intent wrongIntent = new Intent(hal_scan.this, hal_scanno.class);
                            startActivity(wrongIntent);
                        }
                    }
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
                // Start ScannerActivity and wait for the result
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
        // For submitting, start ScannerActivity
        Intent intent = new Intent(hal_scan.this, ScannerActivity.class);
        scanBarcodeLauncher.launch(intent);
    }

    public void cancel(View v) {
        Intent intent = new Intent(hal_scan.this, masukhal.class);
        startActivity(intent);
    }
}

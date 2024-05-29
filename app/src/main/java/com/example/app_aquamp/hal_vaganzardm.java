package com.example.app_aquamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import android.widget.ImageView;

public class hal_vaganzardm extends AppCompatActivity {

    private int counterPlus = 0; // Nilai awal counter untuk tombol plus 1
    private int counterMin = 0; // Nilai awal counter untuk tombol plus 2

    private TextView textPlusMin;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hal_vaganzardm);

        textPlusMin = findViewById(R.id.textplusmin);
        textPlusMin.setText(String.valueOf(total));

        ImageView Plus = findViewById(R.id.plus);
        ImageView Min = findViewById(R.id.min);

        // Menambahkan event listener untuk tombol plus 1
        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlus++; // Menambahkan nilai counter plus 1
                updateCounter(); // Memperbarui tampilan teks
            }
        });

        // Menambahkan event listener untuk tombol minus 1
        Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterPlus > 0) {
                    counterPlus--; // Mengurangi nilai counter plus 1
                    updateCounter(); // Memperbarui tampilan teks
                }
            }
        });
    }

    // Method untuk memperbarui tampilan teks sesuai dengan nilai counter
    private void updateCounter() {
        int total = counterPlus - counterMin; // Total counter 1
        textPlusMin.setText(String.valueOf(total));
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
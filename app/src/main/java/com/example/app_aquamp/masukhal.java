package com.example.app_aquamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ImageView;


import com.google.android.material.navigation.NavigationView;

public class masukhal extends AppCompatActivity {

    private TextView textViewPlusMin1;
    private TextView textViewPlusMin2;
    private int counterPlus1 = 0; // Nilai awal counter untuk tombol plus 1
    private int counterPlus2 = 0; // Nilai awal counter untuk tombol plus 2
    private int counterMin1 = 0; // Nilai awal counter untuk tombol minus 1
    private int counterMin2 = 0; // Nilai awal counter untuk tombol minus 2



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_masukhal);
        DrawerLayout drawerLayout = findViewById(R.id.driver_layout);;
        NavigationView navigationView =findViewById(R.id.nav_menu);


        // TextView pertama
        TextView textView1 = findViewById(R.id.textViewrdm);
        applyGradientToTextView(textView1);

        // TextView kedua
        TextView textView2 = findViewById(R.id.textViewrdm2);
        applyGradientToTextView(textView2);

        TextView textView3 = findViewById(R.id.textViewrdm3);
        applyGradientToTextView(textView3);

        TextView textView4 = findViewById(R.id.textViewrdm4);
        applyGradientToTextView(textView4);

        TextView textView5 = findViewById(R.id.textViewrdm5);
        applyGradientToTextView(textView5);

        TextView textView6 = findViewById(R.id.textViewrdm6);
        applyGradientToTextView(textView6);

        textViewPlusMin1 = findViewById(R.id.textViewplusmin1);
        textViewPlusMin2 = findViewById(R.id.textViewplusmin2);

        textViewPlusMin1.setText(String.valueOf(counterPlus1));
        textViewPlusMin2.setText(String.valueOf(counterPlus2));

        ImageView imageButtonPlus1 = findViewById(R.id.imageButtonplus1);
        ImageView imageButtonPlus2 = findViewById(R.id.imageButtonplus2);
        ImageView imageButtonMin1 = findViewById(R.id.imageButtonmin1);
        ImageView imageButtonMin2 = findViewById(R.id.imageButtonmin2);



        // Menambahkan event listener untuk tombol plus 1
        imageButtonPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlus1++; // Menambahkan nilai counter plus 1
                updateCounter(); // Memperbarui tampilan teks
            }
        });

        // Menambahkan event listener untuk tombol plus 2
        imageButtonPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlus2++; // Menambahkan nilai counter plus 2
                updateCounter(); // Memperbarui tampilan teks
            }
        });

        // Menambahkan event listener untuk tombol minus 1
        imageButtonMin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterPlus1 > 0) {
                    counterPlus1--; // Mengurangi nilai counter plus 1
                    updateCounter(); // Memperbarui tampilan teks
                }
            }
        });

        // Menambahkan event listener untuk tombol minus 2
        imageButtonMin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterPlus2 > 0) {
                    counterPlus2--; // Mengurangi nilai counter plus 2
                    updateCounter(); // Memperbarui tampilan teks
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.logout) {
                // Buka halaman pertama jika item menu 1 diklik
                Intent intent1 = new Intent(masukhal.this, login.class);
                startActivity(intent1);
            }

            drawerLayout.closeDrawers();
            return true;
        });

    }

    private void applyGradientToTextView(TextView textView) {
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        0xFF1A529D,// start color 000080
                        0xFF2E9271,
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }

    public void openDrawer(View view) {
        DrawerLayout drawerLayout = findViewById(R.id.driver_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            drawerLayout.openDrawer(GravityCompat.END);
        }

    }

    // Method untuk memperbarui tampilan teks sesuai dengan nilai counter
    private void updateCounter() {
        int total1 = counterPlus1 - counterMin1; // Total counter 1
        int total2 = counterPlus2 - counterMin2; // Total counter 2
        textViewPlusMin1.setText(String.valueOf(total1));
        textViewPlusMin2.setText(String.valueOf(total2));
    }

    public void openscan(View v) {
        Intent intent = new Intent (masukhal.this, hal_scan.class);
        startActivity(intent);
    }

    public void opendiskon(View v) {
        Intent intent = new Intent (masukhal.this, hal_vaganzardm.class);
        startActivity(intent);
    }

    public void opengift(View v) {
        Intent intent = new Intent (masukhal.this, hal_selamatekstra.class);
        startActivity(intent);
    }

    public void openroyal(View v) {
        Intent intent = new Intent (masukhal.this, royal.class);
        startActivity(intent);
    }

}
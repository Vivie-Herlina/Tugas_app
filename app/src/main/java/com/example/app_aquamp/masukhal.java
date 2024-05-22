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

import com.google.android.material.navigation.NavigationView;

public class masukhal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_masukhal);
        DrawerLayout drawerLayout = findViewById(R.id.driver_layout);;
        NavigationView navigationView =findViewById(R.id.nav_menu);


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

    public void openDrawer(View view) {
        DrawerLayout drawerLayout = findViewById(R.id.driver_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            drawerLayout.openDrawer(GravityCompat.END);
        }

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
        Intent intent = new Intent (masukhal.this, hal_ekstravaganza.class);
        startActivity(intent);
    }

}
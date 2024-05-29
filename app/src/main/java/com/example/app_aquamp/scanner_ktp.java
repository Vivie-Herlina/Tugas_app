package com.example.app_aquamp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import java.io.IOException;
import android.widget.ImageView;

public class scanner_ktp extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;

    SurfaceView surfaceView2;
    TextView txtBarcodeValue2;
    CameraSource cameraSource;
    TextRecognizer textRecognizer;
    ImageView imageView; // Deklarasikan ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_ktp);

        surfaceView2 = findViewById(R.id.surfaceView2);
        txtBarcodeValue2 = findViewById(R.id.txtBarcodeValue2);
        imageView = findViewById(R.id.imageView); // Inisialisasi ImageView

        // Inisialisasi TextRecognizer
        textRecognizer = new TextRecognizer.Builder(this).build();

        // Check camera permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 123);
        } else {
            startScanning();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Menampilkan gambar di ImageView
            imageView.setImageBitmap(photo);
        }
    }

    public void startScanning() {
        // Implementasi logika untuk memulai pemindaian di sini
        // Contoh:
        if (!textRecognizer.isOperational()) {
            Toast.makeText(this, "Text recognizer could not be set up on your device", Toast.LENGTH_SHORT).show();
            return;
        }

        cameraSource = new CameraSource.Builder(this, textRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280, 1024)
                .setRequestedFps(2.0f)
                .setAutoFocusEnabled(true)
                .build();

        surfaceView2.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(scanner_ktp.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(scanner_ktp.this, new String[]{Manifest.permission.CAMERA}, 123);
                        return;
                    }
                    cameraSource.start(surfaceView2.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<TextBlock> detections) {
                final SparseArray<TextBlock> items = detections.getDetectedItems();
                if (items.size() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < items.size(); ++i) {
                        TextBlock item = items.valueAt(i);
                        stringBuilder.append(item.getValue());
                        stringBuilder.append("\n");
                    }
                    final String detectedText = stringBuilder.toString();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txtBarcodeValue2.setText(detectedText);
                        }
                    });
                }
            }
        });
    }

    public void save(View v) {
        Intent intent = new Intent(scanner_ktp.this, masukhal.class);
        startActivity(intent);
    }
}
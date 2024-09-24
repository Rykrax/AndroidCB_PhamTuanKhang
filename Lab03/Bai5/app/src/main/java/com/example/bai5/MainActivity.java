package com.example.bai5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSum, btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSum = findViewById(R.id.btnSum);
        btnList = findViewById(R.id.btnList);

        btnSum.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TinhTong.class);
            startActivity(intent);
        });

        btnList.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DanhSach.class);
            startActivity(intent);
        });
    }
}
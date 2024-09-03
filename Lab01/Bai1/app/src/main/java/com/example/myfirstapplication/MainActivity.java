package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText etX, etY;
    TextView tvResult;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
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
        etX = findViewById(R.id.etX);
        etY = findViewById(R.id.etY);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnMod = findViewById(R.id.btnMod);

        btnAdd.setOnClickListener(view -> {
            try {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                tvResult.setText(String.valueOf(x+y));
            }
            catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnSub.setOnClickListener(view -> {
            try {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                tvResult.setText(String.valueOf(x-y));
            }
            catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnMul.setOnClickListener(view -> {
            try {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                tvResult.setText(String.valueOf(x*y));
            }
            catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnDiv.setOnClickListener(view -> {
            try {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                tvResult.setText(String.valueOf(x/y));
            }
            catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnMod.setOnClickListener(view -> {
            try {
                int x = Integer.parseInt(etX.getText().toString());
                int y = Integer.parseInt(etY.getText().toString());
                tvResult.setText(String.valueOf(x%y));
            }
            catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
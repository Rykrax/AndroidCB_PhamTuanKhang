package com.example.bai2;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtFah, edtCel;
    Button btnToCel, btnToFah, btnClear;
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
        loadView();
        actionView();
    }

    public void loadView() {
        edtCel = findViewById(R.id.edtCel);
        edtFah = findViewById(R.id.edtFah);
        btnToCel = findViewById(R.id.btnToCel);
        btnToFah = findViewById(R.id.btnToFah);
        btnClear = findViewById(R.id.btnClear);
    }

    public void actionView() {
        btnToCel.setOnClickListener(view -> {
            try {
                float f = Float.parseFloat(edtFah.getText().toString());
                float c = (f-32.0f) * 5/9;
                edtCel.setText(String.format("%.2f", c));
            }
            catch(NumberFormatException ex) {
                Toast.makeText(this, "Vui lòng nhập dữ liệu Fahrenheit ", Toast.LENGTH_SHORT).show();
            }
            catch(Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        btnToFah.setOnClickListener(view -> {
            try {
                float c = Float.parseFloat(edtCel.getText().toString());
                float f = c * 9.0f / 5 + 32;
                edtCel.setText(String.format("%.2f", f));
            }
            catch(NumberFormatException ex) {
                Toast.makeText(this, "Vui lòng nhập dữ liệu Celsius  ", Toast.LENGTH_SHORT).show();
            }
            catch(Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.bai1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    EditText edtA, edtB;
    Button btnSum, btnSub, btnMul, btnDiv, btnGcd, btnExit;
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
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        tvResult = findViewById(R.id.tvResult);
        btnSum = findViewById(R.id.btnSum);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnGcd = findViewById(R.id.btnGcd);
        btnExit = findViewById(R.id.btnExit);
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public void actionView() {
        btnSum.setOnClickListener(view -> {
            try {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                tvResult.setText(String.valueOf(a+b));
            }
            catch(Exception ex) {
                Log.e("Error:", ex.getMessage());
            }
        });

        btnSub.setOnClickListener(view -> {
            try {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                tvResult.setText(String.valueOf(a-b));
            }
            catch(Exception ex) {
                Log.e("Error:", ex.getMessage());
            }
        });

        btnMul.setOnClickListener(view -> {
            try {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                tvResult.setText(String.valueOf(a*b));
            }
            catch(Exception ex) {
                Log.e("Error:", ex.getMessage());
            }
        });

        btnDiv.setOnClickListener(view -> {
            try {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                tvResult.setText(String.valueOf(a/b));
            }
            catch(Exception ex) {
                Log.e("Error:", ex.getMessage());
            }
        });

        btnGcd.setOnClickListener(view -> {
            try {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                tvResult.setText(String.valueOf(gcd(a,b)));
            }
            catch(Exception ex) {
                Log.e("Error:", ex.getMessage());
            }
        });

        btnExit.setOnClickListener(view -> {
            finish();
        });
    }
}
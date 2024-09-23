package com.example.bai1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public boolean checkValue() {
        if (edtA.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nhập giá trị a", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (edtB.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nhập giá trị b", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public int tryParseInt(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    public void actionView() {
        btnSum.setOnClickListener(view -> {
            if (!checkValue()) return;
            int a = tryParseInt(edtA.getText().toString(),-10);
            int b = tryParseInt(edtB.getText().toString(),-10);
            if (a==-10) {
                Toast.makeText(this, "Dữ liệu a không phù hợp", Toast.LENGTH_SHORT).show();
            } else if (b==-10) {
                Toast.makeText(this, "Dữ liệu b không phù hợp", Toast.LENGTH_SHORT).show();
            } else {
                tvResult.setText(String.valueOf(a+b));
            }
        });

        btnSub.setOnClickListener(view -> {
            if (!checkValue()) return;
            int a = tryParseInt(edtA.getText().toString(),-10);
            int b = tryParseInt(edtB.getText().toString(),-10);
            if (a==-10) {
                Toast.makeText(this, "Dữ liệu a không phù hợp", Toast.LENGTH_SHORT).show();
            } else if (b==-10) {
                Toast.makeText(this, "Dữ liệu b không phù hợp", Toast.LENGTH_SHORT).show();
            } else {
                tvResult.setText(String.valueOf(a-b));
            }
        });

        btnMul.setOnClickListener(view -> {
            if (!checkValue()) return;
            int a = tryParseInt(edtA.getText().toString(),-10);
            int b = tryParseInt(edtB.getText().toString(),-10);
            if (a==-10) {
                Toast.makeText(this, "Dữ liệu a không phù hợp", Toast.LENGTH_SHORT).show();
            } else if (b==-10) {
                Toast.makeText(this, "Dữ liệu b không phù hợp", Toast.LENGTH_SHORT).show();
            } else {
                tvResult.setText(String.valueOf(a*b));
            }
        });

        btnDiv.setOnClickListener(view -> {
            if (!checkValue()) return;
            int a = tryParseInt(edtA.getText().toString(),-10);
            int b = tryParseInt(edtB.getText().toString(),-10);
            if (a==-10) {
                Toast.makeText(this, "Dữ liệu a không phù hợp", Toast.LENGTH_SHORT).show();
            } else if (b==-10) {
                Toast.makeText(this, "Dữ liệu b không phù hợp", Toast.LENGTH_SHORT).show();
            } else {
                tvResult.setText(String.valueOf(a/b));
            }
        });

        btnGcd.setOnClickListener(view -> {
            if (!checkValue()) return;
            int a = tryParseInt(edtA.getText().toString(),-10);
            int b = tryParseInt(edtB.getText().toString(),-10);
            if (a==-10) {
                Toast.makeText(this, "Dữ liệu a không phù hợp", Toast.LENGTH_SHORT).show();
            } else if (b==-10) {
                Toast.makeText(this, "Dữ liệu b không phù hợp", Toast.LENGTH_SHORT).show();
            } else {
                tvResult.setText(String.valueOf(gcd(a,b)));
            }
        });

        btnExit.setOnClickListener(view -> {
            finish();
        });
    }
}
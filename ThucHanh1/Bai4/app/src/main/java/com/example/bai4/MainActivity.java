package com.example.bai4;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnBMI;
    EditText edtName, edtHeight, edtWeight, edtBMI, edtDuDoan;
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
        loadViews();
        actionViews();
    }

    public void loadViews() {
        btnBMI = findViewById(R.id.btnBMI);
        edtName = findViewById(R.id.edtName);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        edtBMI = findViewById(R.id.edtBMI);
        edtDuDoan = findViewById(R.id.edtDuDoan);
    }

    public void actionViews() {
        btnBMI.setOnClickListener(view -> {
            try {
                double H = Double.parseDouble(edtHeight.getText().toString());
                double W = Double.parseDouble(edtWeight.getText().toString());
                double BMI = W*1.0f/(H*H);
                String duDoan = "";
                if (BMI<18) duDoan = "Bạn gầy";
                if (BMI<=24.9) duDoan = "Bạn bình thường";
                if (BMI<=29.9) duDoan = "Bạn béo phì cấp độ 1";
                if (BMI<=34.9) duDoan = "Bạn béo phì cấp độ 2";
                else duDoan = "Bạn béo phì cấp độ 3";
//                DecimalFormat dcf = new DecimalFormat("#.0");
//                edtBMI.setText(dcf.format(BMI));
                edtBMI.setText(String.format("%.2f",BMI));
                edtDuDoan.setText(duDoan);
            }
            catch (Exception ex) {
                Toast.makeText(this, "Dữ liệu không phù hợp", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
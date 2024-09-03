package com.example.bai2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    ImageView imgView;
    TextView tvSpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgView = (ImageView) findViewById(R.id.imgView);
        tvSpan = findViewById(R.id.tvSpan);

        imgView.setImageResource(R.drawable.img1);

        tvSpan.setOnClickListener(view -> {
            Random rand = new Random();
            int x = rand.nextInt(6);
            if (x==0) imgView.setImageResource(R.drawable.img1);
            if (x==1) imgView.setImageResource(R.drawable.img2);
            if (x==2) imgView.setImageResource(R.drawable.img3);
            if (x==3) imgView.setImageResource(R.drawable.img4);
            if (x==4) imgView.setImageResource(R.drawable.img5);
            if (x==5) imgView.setImageResource(R.drawable.img6);
        });
    }
}
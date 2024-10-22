package com.example.lab01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {
    Button btnExit;
    TextView edtShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnExit = findViewById(R.id.btnExit);
        edtShow = findViewById(R.id.edtShow);
        loadData();

        btnExit.setOnClickListener(view -> {
            SharedPreferences sp = this.getSharedPreferences("Account", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("save",false);
            editor.putString("username","");
            editor.putString("password","");
            editor.apply();
            Intent intent = new Intent(Profile.this, MainActivity.class);
            startActivity(intent);
        });
    }
    void loadData() {
        SharedPreferences sp = this.getSharedPreferences("Account", Context.MODE_PRIVATE);
        String username = sp.getString("username","");
        edtShow.setText(String.format("Hello: %s", username));
    }
}
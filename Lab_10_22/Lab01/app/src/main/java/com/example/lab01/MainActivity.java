package com.example.lab01;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    CheckBox chkSave;
    Button btnLogin;
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
        loadControl();
        restoringAccount();
        btnLogin.setOnClickListener(view -> {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Nhập dữ liệu", Toast.LENGTH_SHORT).show();
                return;
            }
            saveAccount(username,password);
            Intent intent = new Intent(MainActivity.this, Profile.class);
            startActivity(intent);
        });
    }

    void loadControl() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkSave = findViewById(R.id.chkSave);
        btnLogin = findViewById(R.id.btnLogin);
    }

    void saveAccount(String username, String password) {
        boolean save = chkSave.isChecked();
        SharedPreferences sp = this.getSharedPreferences("Account", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (save) {
            editor.putBoolean("save",true);
            editor.putString("username",edtUsername.getText().toString());
            editor.putString("password",edtPassword.getText().toString());
        } else {
            editor.putBoolean("save",false);
            editor.putString("username",edtUsername.getText().toString());
        }
        editor.apply();
    }

    void restoringAccount() {
        SharedPreferences sp = this.getSharedPreferences("Account", Context.MODE_PRIVATE);
        boolean save = sp.getBoolean("save",false);
        if (sp!=null && save) {
            Intent intent = new Intent(MainActivity.this, Profile.class);
            startActivity(intent);
        }
    }
}
package com.example.mycontact.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycontact.Contact;
import com.example.mycontact.ContactAdapter;
import com.example.mycontact.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert;
    ListView lstContact;
    ContactAdapter contactAdapter;
    ArrayList<Contact> listContact;
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
//        initData();
        lstContact = findViewById(R.id.lstContact);
        btnInsert = findViewById(R.id.btnInsert);

//        contactAdapter = new ContactAdapter(MainActivity.this,R.layout.item_listview,listContact);
//        lstContact.setAdapter(contactAdapter);
    }

    public void initData() {
        listContact.add(new Contact("Mai", "0983404342"));
        listContact.add(new Contact("Trung", "0312049483"));
    }
}
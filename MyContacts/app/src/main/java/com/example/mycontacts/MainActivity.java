package com.example.mycontacts;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<MyContact> listContacts = new ArrayList<>();
    ContactAdapter contactAdapter;
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
        initData();
        lvContact = findViewById(R.id.lvContacts);
        //khoi tao contactAdapter
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.layout_item_contact, listContacts);
        lvContact.setAdapter(contactAdapter);
    }
    private void initData(){
        listContacts.add(new MyContact(R.drawable.img, "Mai", "0878493835"));
        listContacts.add(new MyContact(R.drawable.img, "Hoang", "0899222235"));
        listContacts.add(new MyContact(R.drawable.img, "Trinh", "0878493835"));
        listContacts.add(new MyContact(R.drawable.img, "Trong", "08789991135"));
        listContacts.add(new MyContact(R.drawable.img, "Hoa", "08700443335"));
    }

}
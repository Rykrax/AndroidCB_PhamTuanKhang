package com.example.truyencuoi;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListTruyen extends AppCompatActivity {
    ListView lvBooks;
    ArrayList<MyBook> listBooks = new ArrayList<>();
    BookAdapter bookAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_truyen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initData();
        lvBooks = findViewById(R.id.lvBooks);
        bookAdapter = new BookAdapter(ListTruyen.this, R.layout.activity_list_truyen, listBooks);
        lvBooks.setAdapter(bookAdapter);
    }

    private void initData() {
        listBooks.add(new MyBook(R.drawable.img,"Công sở"));
        listBooks.add(new MyBook(R.drawable.img,"Cười 18"));
        listBooks.add(new MyBook(R.drawable.img,"Giao thông"));
        listBooks.add(new MyBook(R.drawable.img,"Gia đình"));
    }
}
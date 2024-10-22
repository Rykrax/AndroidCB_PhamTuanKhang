package com.example.myapplication;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton btnShow;
    ListView lvContact;
    String[] contactList = {"0938473847", "0948384927", "0983474583"};
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
        lvContact = findViewById(R.id.lvContact);
        btnShow = findViewById(R.id.btnShow);
        bindingData();
        registerForContextMenu(lvContact);

        btnShow.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnShow);
            popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    Toast.makeText(MainActivity.this, "You click " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
            popupMenu.show();
        });
    }

    //Đăng ký list view
    @Override
    public void registerForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Load option menu hiển thị lên activity
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.newGame) {
            Toast.makeText(this, "New Game", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.menuHelp) {
            Toast.makeText(this, "Menu Help", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.addNew) {
            Toast.makeText(this,"add new", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.infor) {
            Toast.makeText(this,"information", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.delete) {
            Toast.makeText(this,"delete", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void bindingData() {
        Adapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contactList);
        lvContact.setAdapter((ListAdapter) adapter);
    }


}
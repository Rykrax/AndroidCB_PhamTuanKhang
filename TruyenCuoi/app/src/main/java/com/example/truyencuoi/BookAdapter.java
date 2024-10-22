package com.example.truyencuoi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<MyBook> {
    Activity context;
    int layout;
    ArrayList<MyBook> listBooks;

    public BookAdapter(@NonNull Activity context, int resource, ArrayList<MyBook> listBooks) {
        super(context, resource, listBooks);
        this.context = context;
        this.layout = resource;
        this.listBooks = listBooks;
    }

    @Nullable
    @Override
    public MyBook getItem(int position) {
        return listBooks.get(position);
    }

    @Override
    public int getCount() {
        return listBooks.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        if (currentView == null) {
            currentView = LayoutInflater.from(context).inflate(layout, parent, false);
        }

        MyBook myBook = getItem(position);
        ImageView imgBook = currentView.findViewById(R.id.imgBook);
        TextView txtBook = currentView.findViewById(R.id.txtBook);
//
//        assert myBook != null;
        txtBook.setText("hehe");
        imgBook.setImageResource(R.drawable.img);
        return currentView;
    }
}

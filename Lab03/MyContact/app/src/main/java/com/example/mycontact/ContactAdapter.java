package com.example.mycontact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Context context;
    int layout;
    ArrayList<Contact> myList;

    public ContactAdapter(@NonNull Context context, int resource, ArrayList<Contact> listContact) {
        super(context, resource, listContact);
        this.context = context;
        this.layout = resource;
        this.myList = listContact;
    }

    //Viết lại các phương thức getCount, getItem, getView

    @Nullable
    @Override
    public Contact getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        if (currentView == null) {
            currentView = LayoutInflater.from(context).inflate(layout,parent);
        }
        Contact contact = getItem(position);
        ImageView imgAvatar = currentView.findViewById(R.id.imgAvatar);
        TextView txtName = currentView.findViewById(R.id.txtName);
        Button btnCall = currentView.findViewById(R.id.btnCall);
        Button btnSend = currentView.findViewById(R.id.btnSend);

        txtName.setText(contact.getName());

//        btnCall.setOnClickListener(view -> {
//            Intent intentCall = new Intent(Intent.ACTION_CALL);
//            intentCall.setData(Uri.parse("tel:" + contact.getSdt()));
//            context.startActivity(intentCall);
//        });

        btnSend.setOnClickListener(view -> {

        });
        return convertView;
    }
}

package com.example.securechatapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    //Recycler instantiation
    private RecyclerView contactsList;
    //chat_interface

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_interface);

        contactsList = findViewById(R.id.contactsList);

        ArrayList<Test_data> contacts = new ArrayList<>();

        contacts.add(new Test_data("abc","abc"));
        contacts.add(new Test_data("pqr","hans"));
        contacts.add(new Test_data("abc","abc"));
        contacts.add(new Test_data("pqr","hans"));
        contacts.add(new Test_data("abc","abc"));
        contacts.add(new Test_data("pqr","hans"));
        contacts.add(new Test_data("abc","abc"));
        contacts.add(new Test_data("pqr","hans"));
        contacts.add(new Test_data("abc","abc"));
        contacts.add(new Test_data("pqr","hans"));
        contacts.add(new Test_data("abc","abc"));
        contacts.add(new Test_data("pqr","hans"));
        contacts.add(new Test_data("abc","abc"));
        contacts.add(new Test_data("pqr","hans"));

        ChatInterfaceRecyclerAdapter adapter = new ChatInterfaceRecyclerAdapter(contacts, new ChatInterfaceRecyclerAdapter.selectListener() {
            @Override
            public void onClickListener(int position) {
                // Handle item click here, for example:

            }
        });

        adapter.setContacts(contacts);

        contactsList.setAdapter(adapter);
        contactsList.setLayoutManager(new LinearLayoutManager(this));


    }
}


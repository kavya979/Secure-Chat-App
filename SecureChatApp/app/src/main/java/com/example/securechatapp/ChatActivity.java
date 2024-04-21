package com.example.securechatapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);
        // Get the name of the contact from the intent
        String contactName = getIntent().getStringExtra("contactName");

        // Set the title of the activity to the contact's name
        setTitle(contactName);

        // Example: Display the contact's name in a TextView
        TextView textView = findViewById(R.id.contact_name_text_view);
        textView.setText(contactName);
    }
}
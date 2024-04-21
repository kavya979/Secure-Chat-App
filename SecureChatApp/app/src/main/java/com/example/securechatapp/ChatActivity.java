package com.example.securechatapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private EditText chatInputEditText;
    private RecyclerView chatRecyclerView;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatInputEditText = findViewById(R.id.chat_input_edit_text);
        chatRecyclerView = findViewById(R.id.chat_recycler_view);

        // Set up RecyclerView
        chatAdapter = new ChatAdapter();
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatRecyclerView.setAdapter(chatAdapter);
        String contactName = getIntent().getStringExtra("contactName");

        // Set the contact's name in the TextView
        TextView contactNameTextView = findViewById(R.id.contact_name_text_view);
        contactNameTextView.setText(contactName);

        // Dummy data for demonstration
        //List<String> initialMessages = new ArrayList<>();
        //initialMessages.add("Hello!");
        //initialMessages.add("How are you?");
        //initialMessages.add("I'm doing well, thanks!");

        //chatAdapter.setMessages(initialMessages);

        // Set OnClickListener for sending messages
        findViewById(R.id.send_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = chatInputEditText.getText().toString().trim();
        if (!message.isEmpty()) {
            // Add the message to the dataset
            chatAdapter.addMessage(message);

            // Scroll RecyclerView to the last item (latest message)
            chatRecyclerView.scrollToPosition(chatAdapter.getItemCount() - 1);

            // Clear the input field
            chatInputEditText.getText().clear();
        } else {
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show();
        }
    }
}
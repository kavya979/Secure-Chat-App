package com.example.securechatapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private ChatInterfaceRecyclerAdapter adapter;
    public ArrayList<Test_data> contacts;

    //private SelectGender selectGender;


    // TO- DO --->>    change the manifest.xml file to login page as launcher and create a separate activity for chat interface...........

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_interface);

        //
        recyclerView = findViewById(R.id.contactsList);
        searchView = findViewById(R.id.searchView);

        // sample data.......aprm ah change pannanum
        contacts = new ArrayList<>();
        contacts.add(new Test_data("Alice", "alice123", "Female"));
        contacts.add(new Test_data("Bob", "bob456","Male"));
        contacts.add(new Test_data("Charlie", "charlie789","Male"));
        contacts.add(new Test_data("David", "david101","Male"));

        contacts.add(new Test_data("Alice", "alice123", "Female"));
        contacts.add(new Test_data("Bob", "bob456","Male"));
        contacts.add(new Test_data("Charlie", "charlie789","Male"));
        contacts.add(new Test_data("David", "david101","Male"));

        contacts.add(new Test_data("Alice", "alice123", "Female"));
        contacts.add(new Test_data("Bob", "bob456","Male"));
        contacts.add(new Test_data("Charlie", "charlie789","Male"));
        contacts.add(new Test_data("David", "david101","Male"));

        //select gender

        // Inside your MainActivity.java file



        // Set up RecyclerView
        adapter = new ChatInterfaceRecyclerAdapter(contacts, new ChatInterfaceRecyclerAdapter.SearchListener() {
            @Override
            public void onSelect(int position) {
                // Handle item selection


            }
        }, new ChatInterfaceRecyclerAdapter.SelectListener() {
            @Override
            public void onClickListener(int position) {
                // Handle item click
                Test_data selectedContact = contacts.get(position);
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                intent.putExtra("contactName", selectedContact.getNames());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        }
    public void filter(String query){
        List<Test_data> filterContacts = new ArrayList<Test_data>();
        for (Test_data item : contacts){
            if(item.getNames().toLowerCase().contains(query.toLowerCase())){
                filterContacts.add(item);
            }
        }
        adapter.filter1(filterContacts);
    }

}


// copy the coe of main class and paste it in the chat interface class.





/* public class ChatInterface extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
*/







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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.database.DatabaseReference;
import android.util.Log;


// MainActivity.java

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private RecyclerView recyclerView;
    private SearchView searchView;
    private ChatInterfaceRecyclerAdapter adapter;
    private ArrayList<UserObject> contacts;
    private CollectionReference collectionReference;
    private DocumentSnapshot document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_interface);

        recyclerView = findViewById(R.id.contactsList);
        searchView = findViewById(R.id.searchView);

        contacts = new ArrayList<UserObject>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        collectionReference = db.collection("users");



        //doc ref
        DocumentReference docRef = db.collection("users").document("user1");

        docRef.get().addOnCompleteListener(task -> {
           if (task.isSuccessful()) {
                document = task.getResult(); // Assign the DocumentSnapshot to the document variable
            }
        });

        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot snapshot, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.e(TAG, "Listen failed: " + error);
                    return;
                }

                if (snapshot != null) {
                    for (DocumentSnapshot document1 : snapshot.getDocuments()) {
                        // Handle each document here
                        String documentId = document1.getId();
                        UserObject user = document1.toObject(UserObject.class);
                        contacts.add(user);
                    }
                    adapter.notifyDataSetChanged(); // Notify adapter of data changes
                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });

        adapter = new ChatInterfaceRecyclerAdapter(contacts, new ChatInterfaceRecyclerAdapter.SearchListener() {
            @Override
            public void onSelect(int position) {
                // Handle item selection
            }
        }, new ChatInterfaceRecyclerAdapter.SelectListener() {
            @Override
            public void onClickListener(int position) {
                UserObject selectedContact = contacts.get(position);
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                intent.putExtra("contactName", selectedContact.getUsername());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        ArrayList<UserObject> filterContacts = new ArrayList<>();
        for (UserObject item : contacts){
            if(item.getUsername().toLowerCase().startsWith(query.toLowerCase())){
                filterContacts.add(item);
            }
        }
        adapter.filter1(filterContacts);
    }

}






// copy the code of main class and paste it in the chat interface class.





/* public class ChatInterface extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
*/
package com.example.securechatapp.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtils {

    public static String getUser(){
        return FirebaseAuth.getInstance().getUid();
    }
    public static DocumentReference currentUserData(){
        return FirebaseFirestore.getInstance().collection("users").document(getUser());
    }

}

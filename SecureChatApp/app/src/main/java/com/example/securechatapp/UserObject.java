package com.example.securechatapp;

public class UserObject {
    private String username;
    private String phone;

    public UserObject() {
        // Required empty public constructor for Firestore
    }
    public UserObject(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

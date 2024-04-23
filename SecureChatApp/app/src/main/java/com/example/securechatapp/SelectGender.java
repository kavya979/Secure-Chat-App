package com.example.securechatapp;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.securechatapp.R.drawable;

public class SelectGender extends AppCompatActivity {
    private boolean isMale ;
    private MainActivity data;


    @SuppressLint("ResourceType")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_layout);

        data = new MainActivity();
    }
    private void Select_gender(String gender){
        if(gender == "Male") {
            isMale = true;
        }
        else {
            isMale = false;
        }
        ImageView avatarImageView = findViewById(R.id.avatarImageView);
        setAvatarImage(avatarImageView, isMale);
    }

    private void setAvatarImage(ImageView imageView, boolean isMale) {
        // Get the drawable based on the current gender state

        if (isMale) {
            imageView.setImageResource(R.drawable.avatar_male);
        } else {
            imageView.setImageResource(R.drawable.avatar_female);
        }


    }



    }


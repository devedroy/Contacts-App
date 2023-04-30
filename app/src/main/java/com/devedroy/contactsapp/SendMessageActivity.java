package com.devedroy.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.devedroy.contactsapp.databinding.ActivitySendMessageBinding;

public class SendMessageActivity extends AppCompatActivity {
    private ActivitySendMessageBinding messageBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messageBinding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(messageBinding.getRoot());
    }
}
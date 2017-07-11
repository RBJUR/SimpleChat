package com.example.roquebuarquejr.simplechat.chat.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.roquebuarquejr.simplechat.R;
import com.firebase.client.Firebase;

/**
 * Created by roque
 */
public class ChatScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_service);
        Firebase.setAndroidContext(this);
        Toast.makeText(ChatScreenActivity.this, "Welcome, " + getIntent().getStringExtra("username") + "!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.chat_activity_frame_layout, new ChatFragment(), "chat");
        transaction.commit();
    }

}

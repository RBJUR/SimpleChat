package com.example.roquebuarquejr.simplechat.chat.view;

import android.content.Context;
import android.content.Intent;
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

    private static final String EXTRA_USER_NAME = "EXTRA_USER_NAME";
    private static final String EXTRA_USER_ID = "EXTRA_USER_ID";
    private static final String EXTRA_USER_MY_ID = "EXTRA_USER_MY_ID";

    public static Intent getStartIntent(Context context, String userName, String myUid, String uid){
        Intent intent = new Intent(context, ChatScreenActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        intent.putExtra(EXTRA_USER_ID, uid);
        intent.putExtra(EXTRA_USER_MY_ID, myUid);
        return  intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_service);
        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.chat_activity_frame_layout, ChatFragment.newInstance(getIntent().getStringExtra(EXTRA_USER_NAME),
                getIntent().getStringExtra(EXTRA_USER_ID), getIntent().getStringExtra(EXTRA_USER_MY_ID)), "chat");
        transaction.commit();
    }

}

package com.example.roquebuarquejr.simplechat.chat.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.user.adapter.CustomUsersAdapter;

/**
 * Created by roquebuarquejr on 08/07/17.
 */

public class UserListActivity  extends AppCompatActivity {

    private RecyclerView userList;
    private CustomUsersAdapter adapter;

    public static Intent getStartIntent(Context context){
        return new Intent(context, UserListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_online_users_list);
        createUI();
        fillUI();
    }

    private void fillUI() {
        adapter = new CustomUsersAdapter();
        adapter.request();
        userList.setAdapter(adapter);
    }


    private void createUI() {
        userList  = (RecyclerView) findViewById(R.id.online_user_recycler_view);
        userList.setLayoutManager(new LinearLayoutManager(this));
        userList.setHasFixedSize(true);
        userList.setItemAnimator(new DefaultItemAnimator());
    }
}

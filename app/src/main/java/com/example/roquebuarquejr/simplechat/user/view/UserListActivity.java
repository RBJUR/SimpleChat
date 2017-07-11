package com.example.roquebuarquejr.simplechat.user.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.user.adapter.CustomUsersAdapter;

/**
 * Created by roquebuarquejr on 11/07/17.
 */

public class UserListActivity extends AppCompatActivity {

    private static final String EXTRA_USER_ID = "EXTRA_USER_ID";
    private static final String EXTRA_USER_NAME = "EXTRA_USER_NAME";

    private RecyclerView userList;
    private CustomUsersAdapter adapter;

    public static Intent getStartIntent(Context context, String userId, String userName){
        Intent intent = new Intent(context, UserListActivity.class);
        intent.putExtra(EXTRA_USER_ID, userId);
        intent.putExtra(EXTRA_USER_NAME, userName);
        return intent;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        bindFields();

    }

    private void bindFields() {

        userList = (RecyclerView) findViewById(R.id.online_user_recycler_view);
        userList.setLayoutManager(new LinearLayoutManager(this));
        userList.setHasFixedSize(true);
        userList.setItemAnimator(new DefaultItemAnimator());

        adapter = new CustomUsersAdapter();
        adapter.request();
        userList.setAdapter(adapter);
    }


}

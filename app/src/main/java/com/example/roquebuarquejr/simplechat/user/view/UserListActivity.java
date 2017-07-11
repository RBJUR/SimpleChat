package com.example.roquebuarquejr.simplechat.user.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.chat.view.ChatScreenActivity;
import com.example.roquebuarquejr.simplechat.model.User;
import com.example.roquebuarquejr.simplechat.user.adapter.CustomUsersAdapter;
import com.example.roquebuarquejr.simplechat.user.adapter.UserAdapterView;
import com.example.roquebuarquejr.simplechat.user.presenter.UsersPresenterImpl;

import java.util.ArrayList;


/**
 * Created by roquebuarquejr on 11/07/17.
 */

public class UserListActivity extends AppCompatActivity implements View.OnClickListener, UserAdapterView {

    private static final String EXTRA_USER_ID = "EXTRA_USER_ID";
    private static final String EXTRA_USER_NAME = "EXTRA_USER_NAME";

    private RecyclerView recyclerView;
    private CustomUsersAdapter adapter;

    private ArrayList<User> userList = new ArrayList<>();
    private UsersPresenterImpl presenter;

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
        presenter = new UsersPresenterImpl(this);
        presenter.request();
    }

    @Override
    public void onClick(View v) {
        int itemPosition = recyclerView.getChildLayoutPosition(v);
        User item = userList.get(itemPosition);
        startActivity(ChatScreenActivity.getStartIntent(this, item.getUsername()));

    }

    @Override
    public void addAll(ArrayList<User> users) {
        userList = users;
        bindFields();

    }

    @Override
    public void request() {
        //DO NOTHING
    }

    private void bindFields() {

        recyclerView = (RecyclerView) findViewById(R.id.online_user_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new CustomUsersAdapter(userList, this);
        recyclerView.setAdapter(adapter);
    }

}

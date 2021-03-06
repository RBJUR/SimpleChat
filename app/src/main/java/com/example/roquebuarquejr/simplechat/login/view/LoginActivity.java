package com.example.roquebuarquejr.simplechat.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.login.presenter.FirebaseLoginPresenterImpl;
import com.example.roquebuarquejr.simplechat.user.view.UserListActivity;
import com.firebase.client.Firebase;

/**
 * Created by roque
 */
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private ProgressBar mProgressBar;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private FirebaseLoginPresenterImpl presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        createUI();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void logTheUserIn(String username, String uid) {
        startActivity(UserListActivity.getStartIntent(this, uid, username));
    }

    @Override
    public void onFailure() {
        Toast.makeText(LoginActivity.this, R.string.on_failure_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void spinProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void createUI() {
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mEmailEditText = (EditText) findViewById(R.id.login_email_edit_text);
        mPasswordEditText = (EditText) findViewById(R.id.login_password_edit_text);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);
        presenter = new FirebaseLoginPresenterImpl(this);
    }

    @Override
    public void onClick(View v) {
        presenter.receiveUserLogin(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
    }
}

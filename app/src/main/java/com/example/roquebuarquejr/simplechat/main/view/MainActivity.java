package com.example.roquebuarquejr.simplechat.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.login.view.LoginActivity;
import com.example.roquebuarquejr.simplechat.registration.view.RegisterActivity;
import com.firebase.client.Firebase;

/**
 * Created by roque
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mLoginButton;
    private Button mRegisterButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        setUI();
    }


    private void setUI() {
        mLoginButton = (Button) findViewById(R.id.login_button);
        mRegisterButton = (Button) findViewById(R.id.register_button);

        mLoginButton.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (v == mRegisterButton) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }


}
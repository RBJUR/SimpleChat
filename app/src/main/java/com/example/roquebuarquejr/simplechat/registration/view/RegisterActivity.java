package com.example.roquebuarquejr.simplechat.registration.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.roquebuarquejr.simplechat.R;
import com.firebase.client.Firebase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements  RegisterView  {

    @BindView(R.id.register_edt_email)
    EditText edtName;


    @BindView(R.id.register_edt_email)
    EditText edtEmail;

    @BindView(R.id.register_edt_email)
    EditText edtPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onSuccess() {
        //TO DO CALL CHATSCREEN
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void spinProgressBar() {

    }

    @Override
    public void stopProgressBar() {

    }
}
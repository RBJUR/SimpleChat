package com.example.roquebuarquejr.simplechat.registration.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.registration.presenter.UserRegisterPresenterImpl;
import com.firebase.client.Firebase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    @BindView(R.id.register_edt_name)
    EditText edtName;
    @BindView(R.id.register_edt_email)
    EditText edtEmail;
    @BindView(R.id.register_edt_password)
    EditText edtPassword;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private String name;
    private String email;
    private String password;

    private UserRegisterPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        Firebase.setAndroidContext(this);

        presenter = new UserRegisterPresenterImpl(this);
    }


    @OnClick(R.id.register_button)
    void btnRegisterClick() {
        if (validateFields()) {
            presenter.receiveRegisterRequest(name,
                    email, password);
        }else{
            showMessage("Preencha todos os campos");
        }
    }


    @Override
    public void onSuccess() {
        //TO DO CALL CHATSCREEN
        finish();
    }

    @Override
    public void onFailure(String message) {
        showMessage(message);
    }

    @Override
    public void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }


    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private boolean validateFields() {
        name = edtName.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        password = edtPassword.getText().toString().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return false;
        }
        return true;
    }
}
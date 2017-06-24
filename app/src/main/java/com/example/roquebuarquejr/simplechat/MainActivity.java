package com.example.roquebuarquejr.simplechat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by roquebuarquejr on 16/06/17.
 */

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn;
    private Button btnSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

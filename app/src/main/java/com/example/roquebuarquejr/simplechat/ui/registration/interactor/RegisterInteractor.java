package com.example.roquebuarquejr.simplechat.ui.registration.interactor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.roquebuarquejr.simplechat.ui.registration.presenter.FirebaseUserRegisterPresenter;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roque
 */
public class RegisterInteractor implements RInteractor {
    private Firebase userRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/Users/");
    private final FirebaseUserRegisterPresenter presenter;
    private FirebaseAuth firebaseAuth;

    public RegisterInteractor(FirebaseUserRegisterPresenter pre) {
        this.presenter = pre;
    }

    @Override
    public void receiveRegisterRequest(final String username, String email, String password, final String emoji) {
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            AuthResult result = task.getResult();
                            String uid = result.getUser().getUid();
                            userRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/Users/" + uid);
                            userRef.setValue(createUser(username, emoji));
                            presenter.onSuccess();
                        } else {
                            Log.d("AuthFail", task.getException().toString());
                            presenter.onFailure();
                        }

                    }
                });

    }

    @Override
    public Map<String, Object> createUser(String username, String emoji) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("emoji", emoji);
        return user;
    }
}

package com.example.roquebuarquejr.simplechat.registration.interactor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.roquebuarquejr.simplechat.registration.presenter.UserRegisterPresenter;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roque
 */
public class RegisterInteractor {
    private Firebase userRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/Users/");
    private final UserRegisterPresenter presenter;
    private FirebaseAuth firebaseAuth;

    public RegisterInteractor(UserRegisterPresenter pre) {
        this.presenter = pre;
    }

    public void receiveRegisterRequest(final String username, String email, String password) {
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
                            userRef.setValue(createUser(username));
                            presenter.onSuccess();
                        } else {
                            Log.d("AuthFail", task.getException().toString());
                            presenter.onFailure();
                        }

                    }
                });

    }

    public Map<String, Object> createUser(String username) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        return user;
    }
}

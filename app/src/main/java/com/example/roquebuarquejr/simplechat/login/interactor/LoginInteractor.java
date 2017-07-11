package com.example.roquebuarquejr.simplechat.login.interactor;

import android.support.annotation.NonNull;

import com.example.roquebuarquejr.simplechat.model.User;
import com.example.roquebuarquejr.simplechat.login.presenter.FirebaseLoginPresenter;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roque
 */
public class LoginInteractor {
    private Firebase userRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/Users/");
    private final FirebaseLoginPresenter presenter;
    private FirebaseAuth mAuth;

    public LoginInteractor(FirebaseLoginPresenter pre) {
        this.presenter = pre;
    }


    public void attemptToLogIn(final String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            userRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/Users/" + task.getResult().getUser().getUid());
                            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    User user = dataSnapshot.getValue(User.class);
                                    Firebase loggedUser = new Firebase("https://simple-chat-6d9bd.firebaseio.com/currentUsers/" + user.getUid()); //redundant?
                                    loggedUser.setValue(createUser(user.getUsername()));
                                    presenter.onSuccess(user.getUsername(), user.getUid());
                                }

                                @Override
                                public void onCancelled(FirebaseError firebaseError) {
                                }
                            });
                        }else{
                            presenter.onFailure();
                        }

                    }
                });

           }


    public Map<String, Object> createUser(String user) {
        Map<String, Object> userToCreate = new HashMap<>();
        userToCreate.put("username", user);
        return userToCreate;
    }
}

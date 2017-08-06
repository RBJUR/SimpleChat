package com.example.roquebuarquejr.simplechat.user.interactor;

import com.example.roquebuarquejr.simplechat.model.User;
import com.example.roquebuarquejr.simplechat.user.presenter.UsersPresenter;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by roque
 */
public class UsersInteractor {
    private final UsersPresenter presenter;
    private final Firebase usersRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/Users");

    public UsersInteractor(UsersPresenter pre) {
        this.presenter = pre;
    }

    public void request(final String myUserId) {
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<User> mListOfUsers = new ArrayList<>();
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    User user = x.getValue(User.class);
                    if (!myUserId.equals(user.getUid())) {
                        mListOfUsers.add(user);
                    }
                }
                presenter.getChildren(mListOfUsers);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}

package com.example.roquebuarquejr.simplechat.registration.interactor;

import com.example.roquebuarquejr.simplechat.model.User;
import com.example.roquebuarquejr.simplechat.registration.presenter.UsernamePresenter;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by roque
 */
public class UsernameInteractor implements UInteractor {
    private final UsernamePresenter presenter;

    public UsernameInteractor(UsernamePresenter pre) {
        this.presenter = pre;
    }

    @Override
    public void checkIfUsernameExists(final String username) {
        Firebase userRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/Users/");
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean exists = false;
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    User user = x.getValue(User.class);
                    if (user.getUsername().equals(username)) {
                        exists = true;
                        presenter.onUserAlreadyExists();
                    }
                    if (exists) break;
                }
                if (!exists) presenter.onUserDoesNotExist();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}

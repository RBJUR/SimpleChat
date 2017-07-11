package com.example.roquebuarquejr.simplechat.main.interactor;

import com.example.roquebuarquejr.simplechat.main.presenter.MainPresenter;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by roque
 */
public class MainInteractor {
    private final Firebase mainRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/Users");
    private final MainPresenter presenter;

    public MainInteractor(MainPresenter pre) {
        this.presenter = pre;
    }

    public void receiveRequest() {
        mainRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                presenter.sendNumberOfChildren(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}

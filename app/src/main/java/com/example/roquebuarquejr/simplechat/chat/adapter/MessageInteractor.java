package com.example.roquebuarquejr.simplechat.chat.adapter;

import com.example.roquebuarquejr.simplechat.model.Message;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

/**
 * Created by roque
 */
public class MessageInteractor {
    private final MessagePresenter presenter;
    private final Firebase mMessagesRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/messages");
    private final Query mMessageQuery;


    public MessageInteractor(MessagePresenter pre) {
        this.presenter = pre;
        this.mMessageQuery = mMessagesRef.orderByValue().limitToLast(100);
    }

    public void request() {
        mMessageQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                presenter.sendMessageToAdapter(dataSnapshot.getValue(Message.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}

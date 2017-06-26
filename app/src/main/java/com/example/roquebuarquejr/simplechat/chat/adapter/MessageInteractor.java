package com.example.roquebuarquejr.simplechat.chat.adapter;

import android.util.Log;

import com.example.roquebuarquejr.simplechat.model.Message;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roque
 */
public class MessageInteractor {
    private final MessagePresenter presenter;
    private final Firebase mMessagesRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/messages");


    public MessageInteractor(MessagePresenter pre) {
        this.presenter = pre;
    }

    public void request() {

        //You can use the single or the value.. depending if you want to keep track
        mMessagesRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Message> messages = new ArrayList<>();
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Message message = snap.getValue(Message.class);
                    messages.add(message);
                }
                presenter.listMessages(messages);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
    }
}

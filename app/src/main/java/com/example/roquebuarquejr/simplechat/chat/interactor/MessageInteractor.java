package com.example.roquebuarquejr.simplechat.chat.interactor;

import com.example.roquebuarquejr.simplechat.chat.presenter.MessagePresenter;
import com.example.roquebuarquejr.simplechat.model.Message;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roque
 */
public class MessageInteractor {
    private MessagePresenter presenter;
    private Firebase mMessagesRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/messages");
    private Query mMessageQuery;


    public MessageInteractor(MessagePresenter pre) {
        this.presenter = pre;
    }

    public void pushMessageToFirebase(String author, String message, String id) {
        String url = "https://simple-chat-6d9bd.firebaseio.com/messages";
        Firebase messageRef = new Firebase(url);
        messageRef.push().setValue(createMessage(message, author, id));
    }

    public Map<String, Object> createMessage(String message, String author, String id) {
        Map<String, Object> values = new HashMap<>();
        values.put("message", message);
        values.put("author", author);
        values.put("talkid", id);
        return values;
    }

    public void request(String id) {
        if (id != null && !id.isEmpty()) {
            mMessageQuery = mMessagesRef.child("talkid").equalTo(id).orderByValue().limitToLast(100);
        } else {
            mMessageQuery = mMessagesRef.orderByValue().limitToLast(100);
        }

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

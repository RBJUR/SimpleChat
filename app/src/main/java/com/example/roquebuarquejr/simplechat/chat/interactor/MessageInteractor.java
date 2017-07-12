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
    private final MessagePresenter presenter;
    private final Firebase mMessagesRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/messages");
    private final Query mMessageQuery;


    public MessageInteractor(MessagePresenter pre) {
        this.presenter = pre;
        this.mMessageQuery = mMessagesRef.orderByValue().limitToLast(100);
    }


    public void pushMessageToFirebase(String author, String message, String id) {
        String url = "https://simple-chat-6d9bd.firebaseio.com/messages";
        if(id != null && !id.isEmpty()){
            url.concat("/id");
        }
        Firebase messageRef = new Firebase(url);
        messageRef.push().setValue(createMessage(message, author));
    }

    public Map<String, Object> createMessage(String message, String author) {
        Map<String, Object> values = new HashMap<>();
        values.put("message", message);
        values.put("author", author);
        return values;
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

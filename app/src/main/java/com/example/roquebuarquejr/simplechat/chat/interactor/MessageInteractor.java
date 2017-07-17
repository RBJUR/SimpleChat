package com.example.roquebuarquejr.simplechat.chat.interactor;

import android.util.Log;

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

    public void pushMessageToFirebase(String author, String message, String id, String myUid) {
        String url = "https://simple-chat-6d9bd.firebaseio.com/messages";
        Firebase messageRef = new Firebase(url);
        messageRef.push().setValue(createMessage(message, author, id, myUid));
    }

    public Map<String, Object> createMessage(String message, String author, String sendTo, String sendBy) {
        Map<String, Object> values = new HashMap<>();
        values.put("message", message);
        values.put("author", author);
        values.put("sendto", sendTo);
        values.put("sendby", sendBy);
        return values;
    }

    public void request(final String id, final String myUid) {
        mMessageQuery = mMessagesRef.orderByValue().limitToLast(100);
        mMessageQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if (id != null && myUid != null && !id.isEmpty() && !myUid.isEmpty()) {
                    final String sendby = dataSnapshot.child("sendby").getValue(String.class);
                    final String sendto = dataSnapshot.child("sendto").getValue(String.class);
                    if (id.equals(sendto) && myUid.equals(sendby) || id.equals(sendby) && myUid.equals(sendto)) {
                        presenter.sendMessageToAdapter(dataSnapshot.getValue(Message.class));
                    }
                } else {
                    presenter.sendMessageToAdapter(dataSnapshot.getValue(Message.class));
                }

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
                firebaseError.toException().printStackTrace();

            }
        });
    }
}

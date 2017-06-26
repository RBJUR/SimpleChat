package com.example.roquebuarquejr.simplechat.chat.interactor;

import com.example.roquebuarquejr.simplechat.chat.presenter.ChatMessagePresenter;
import com.example.roquebuarquejr.simplechat.model.Message;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roque
 */
//pushes a message to Firebase on every onClick method usage
public class ChatMessageInteractor  {

    private final ChatMessagePresenter presenter;
    private final Firebase mMessagesRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/messages");

    public ChatMessageInteractor(ChatMessagePresenter pre) {
        this.presenter = pre;
    }


    public void pushMessageToFirebase(String author, String message, String emoji) {
        Firebase messageRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/messages");
        messageRef.push().setValue(createMessage(message, author, emoji));
    }

    public Map<String, Object> createMessage(String message, String author, String emoji) {
        Map<String, Object> values = new HashMap<>();
        values.put("message", message);
        values.put("author", author);
        values.put("emoji", emoji);
        return values;
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

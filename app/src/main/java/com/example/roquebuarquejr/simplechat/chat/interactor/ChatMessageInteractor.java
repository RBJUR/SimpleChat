package com.example.roquebuarquejr.simplechat.chat.interactor;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roque
 */
//pushes a message to Firebase on every onClick method usage
public class ChatMessageInteractor  {

    public void pushMessageToFirebase(String author, String message) {
        Firebase messageRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/messages");
        messageRef.push().setValue(createMessage(message, author));
    }

    public Map<String, Object> createMessage(String message, String author) {
        Map<String, Object> values = new HashMap<>();
        values.put("message", message);
        values.put("author", author);
        return values;
    }
}

package com.example.roquebuarquejr.simplechat.ui.chat.interactor;

import com.firebase.client.Firebase;

/**
 * Created by roque
 */
//When the chat activity's onDestroy is called, "logs the User out"
public class ChatLoginInteractor implements CLoginInteractor {
    @Override
    public void logTheUserOut(String uid) {
        Firebase userRef = new Firebase("https://simple-chat-6d9bd.firebaseio.com/currentUsers/" + uid);
        userRef.removeValue();
    }
}

package com.example.roquebuarquejr.simplechat.ui.chat.presenter;

/**
 * Created by Filip on 25/02/2016.
 */
public interface FirebaseChatMessagePresenter {
    void sendMessage(String author, String message, String emoji);
}

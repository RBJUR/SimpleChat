package com.example.roquebuarquejr.simplechat.chat.presenter;

/**
 * Created by roque
 */
public interface FirebaseChatMessagePresenter {
    void sendMessage(String author, String message, String emoji);
}

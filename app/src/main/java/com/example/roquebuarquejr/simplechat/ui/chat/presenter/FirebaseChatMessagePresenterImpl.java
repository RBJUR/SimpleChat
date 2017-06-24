package com.example.roquebuarquejr.simplechat.ui.chat.presenter;


import com.example.roquebuarquejr.simplechat.ui.chat.interactor.ChatMessageInteractor;

/**
 * Created by Filip on 25/02/2016.
 */
public class FirebaseChatMessagePresenterImpl implements FirebaseChatMessagePresenter {
    private final ChatMessageInteractor interactor;

    public FirebaseChatMessagePresenterImpl() {
        this.interactor = new ChatMessageInteractor();
    }

    @Override
    public void sendMessage(String author, String message, String emoji) {
        interactor.pushMessageToFirebase(author, message, emoji);
    }
}

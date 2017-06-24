package com.example.roquebuarquejr.simplechat.ui.chat.presenter;


import com.example.roquebuarquejr.simplechat.ui.chat.interactor.ChatMessageInteractor;

/**
 * Created by roque
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

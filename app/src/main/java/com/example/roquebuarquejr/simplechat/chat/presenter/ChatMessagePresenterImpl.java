package com.example.roquebuarquejr.simplechat.chat.presenter;


import com.example.roquebuarquejr.simplechat.chat.interactor.ChatMessageInteractor;

/**
 * Created by roque
 */
public class ChatMessagePresenterImpl implements ChatMessagePresenter {
    private final ChatMessageInteractor interactor;

    public ChatMessagePresenterImpl() {
        this.interactor = new ChatMessageInteractor();
    }

    @Override
    public void sendMessage(String author, String message, String id) {
        interactor.pushMessageToFirebase(author, message, id);
    }
}

package com.example.roquebuarquejr.simplechat.chat.presenter;


import com.example.roquebuarquejr.simplechat.chat.adapter.MessageAdapterView;
import com.example.roquebuarquejr.simplechat.chat.interactor.ChatMessageInteractor;
import com.example.roquebuarquejr.simplechat.model.Message;

import java.util.List;

/**
 * Created by roque
 */
public class ChatMessagePresenterImpl implements ChatMessagePresenter {
    private final ChatMessageInteractor interactor;
    private final MessageAdapterView adapterView;

    public ChatMessagePresenterImpl(MessageAdapterView view) {
        this.interactor = new ChatMessageInteractor(this);
        this.adapterView = view;

    }

    @Override
    public void listMessages(List<Message> messages) {
        adapterView.listMessages(messages);
    }

    @Override
    public void requestMessages() {
        interactor.request();
    }

    @Override
    public void sendMessage(String author, String message, String emoji) {
        interactor.pushMessageToFirebase(author, message, emoji);
    }

}

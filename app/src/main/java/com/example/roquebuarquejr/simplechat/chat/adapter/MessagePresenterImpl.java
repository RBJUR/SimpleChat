package com.example.roquebuarquejr.simplechat.chat.adapter;


import com.example.roquebuarquejr.simplechat.model.Message;

import java.util.List;

/**
 * Created by roque
 */
public class MessagePresenterImpl implements MessagePresenter {
    private final MessageAdapterView adapterView;
    private final MessageInteractor interactor;

    public MessagePresenterImpl(MessageAdapterView view) {
        this.adapterView = view;
        this.interactor = new MessageInteractor(this);
    }


    @Override
    public void listMessages(List<Message> messages) {
        adapterView.listMessages(messages);
    }

    @Override
    public void requestMessages() {
        interactor.request();
    }
}

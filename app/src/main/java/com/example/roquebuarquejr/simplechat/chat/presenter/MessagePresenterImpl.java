package com.example.roquebuarquejr.simplechat.chat.presenter;


import com.example.roquebuarquejr.simplechat.chat.adapter.MessageAdapterView;
import com.example.roquebuarquejr.simplechat.chat.interactor.MessageInteractor;
import com.example.roquebuarquejr.simplechat.model.Message;

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
    public void sendMessageToAdapter(Message message) {
        adapterView.addItem(message);
    }

    @Override
    public void requestMessages() {
        interactor.request();
    }
}

package com.example.roquebuarquejr.simplechat.chat.adapter;


import com.example.roquebuarquejr.simplechat.model.Message;

/**
 * Created by roque
 */
public interface MessagePresenter {
    void sendMessageToAdapter(Message message);
    void requestMessages();
}

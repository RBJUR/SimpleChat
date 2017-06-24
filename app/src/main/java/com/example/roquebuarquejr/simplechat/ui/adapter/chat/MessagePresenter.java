package com.example.roquebuarquejr.simplechat.ui.adapter.chat;


import com.example.roquebuarquejr.simplechat.model.Message;

/**
 * Created by Filip on 25/02/2016.
 */
public interface MessagePresenter {
    void sendMessageToAdapter(Message message);
    void requestMessages();
}

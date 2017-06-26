package com.example.roquebuarquejr.simplechat.chat.adapter;


import com.example.roquebuarquejr.simplechat.model.Message;

import java.util.List;

/**
 * Created by roque
 */
public interface MessagePresenter {
    void sendMessageToAdapter(Message message);
    void listMessages(List<Message> messages);
    void requestMessages();
}

package com.example.roquebuarquejr.simplechat.chat.presenter;


import com.example.roquebuarquejr.simplechat.model.Message;

import java.util.List;

/**
 * Created by roque
 */
public interface ChatMessagePresenter {
    void sendMessage(String author, String message);
    void addNewMessage(Message message);
    void listMessages(List<Message> messages);
    void requestMessages();
}
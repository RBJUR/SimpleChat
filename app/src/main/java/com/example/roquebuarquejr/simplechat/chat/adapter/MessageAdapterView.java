package com.example.roquebuarquejr.simplechat.chat.adapter;


import com.example.roquebuarquejr.simplechat.model.Message;

import java.util.List;

/**
 * Created by roque
 */
public interface MessageAdapterView {
    void addItem(Message message);
    void request();
    void listMessages(List<Message> messages);
}

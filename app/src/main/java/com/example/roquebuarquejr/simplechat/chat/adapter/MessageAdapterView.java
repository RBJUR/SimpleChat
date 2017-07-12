package com.example.roquebuarquejr.simplechat.chat.adapter;


import com.example.roquebuarquejr.simplechat.model.Message;

/**
 * Created by roque
 */
public interface MessageAdapterView {
    void addItem(Message message);
    void request(String id);
}

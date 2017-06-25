package com.example.roquebuarquejr.simplechat.chat.adapter;


import com.example.roquebuarquejr.simplechat.model.Message;

/**
 * Created by Filip on 25/02/2016.
 */
public interface MessageAdapterView {
    void addItem(Message message);
    void request();
}

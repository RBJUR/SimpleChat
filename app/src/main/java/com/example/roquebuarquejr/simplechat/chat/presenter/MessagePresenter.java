package com.example.roquebuarquejr.simplechat.chat.presenter;


import com.example.roquebuarquejr.simplechat.model.Message;

/**
 * Created by roque
 */
public interface MessagePresenter {
    void sendMessageToAdapter(Message message);
    void requestMessages(String id, String myUid);
    void sendMessage(String author, String message, String id, String myUid);
    void scrollRecyclerView(int position);
}

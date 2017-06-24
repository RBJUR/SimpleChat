package com.example.roquebuarquejr.simplechat.ui.chat.interactor;

import java.util.Map;

/**
 * Created by roque
 */
public interface CMessageInteractor {
    void pushMessageToFirebase(String author, String message, String emoji);

    Map<String, Object> createMessage(String message, String author, String emoji);
}

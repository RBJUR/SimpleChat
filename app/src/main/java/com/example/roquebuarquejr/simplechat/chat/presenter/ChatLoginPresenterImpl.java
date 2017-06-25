package com.example.roquebuarquejr.simplechat.chat.presenter;


import com.example.roquebuarquejr.simplechat.chat.interactor.ChatLoginInteractor;

/**
 * Created by roque
 */
public class ChatLoginPresenterImpl implements ChatLoginPresenter {
    private final ChatLoginInteractor interactor;

    public ChatLoginPresenterImpl() {
        this.interactor = new ChatLoginInteractor();
    }

    @Override
    public void removeUserFromCurrentUsers(String uid) {
        interactor.logTheUserOut(uid);
    }
}

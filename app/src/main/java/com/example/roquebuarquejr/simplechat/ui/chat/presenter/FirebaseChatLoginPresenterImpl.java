package com.example.roquebuarquejr.simplechat.ui.chat.presenter;


import com.example.roquebuarquejr.simplechat.ui.chat.interactor.ChatLoginInteractor;

/**
 * Created by Filip on 23/02/2016.
 */
public class FirebaseChatLoginPresenterImpl implements FirebaseChatLoginPresenter {
    private final ChatLoginInteractor interactor;

    public FirebaseChatLoginPresenterImpl() {
        this.interactor = new ChatLoginInteractor();
    }

    @Override
    public void removeUserFromCurrentUsers(String uid) {
        interactor.logTheUserOut(uid);
    }
}

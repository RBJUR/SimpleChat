package com.example.roquebuarquejr.simplechat.ui.login.presenter;



/**
 * Created by roque
 */
public interface FirebaseLoginPresenter {
    void receiveUserLogin(String email, String password);
    void onFailure();
    void onSuccess(String user, String uid, String emoji);
}

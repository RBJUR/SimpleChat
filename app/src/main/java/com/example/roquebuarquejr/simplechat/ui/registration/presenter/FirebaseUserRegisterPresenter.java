package com.example.roquebuarquejr.simplechat.ui.registration.presenter;

/**
 * Created by roque
 */
public interface FirebaseUserRegisterPresenter {
    void receiveRegisterRequest(String username, String email, String password, String emoji);

    void onFailure();

    void onSuccess();
}

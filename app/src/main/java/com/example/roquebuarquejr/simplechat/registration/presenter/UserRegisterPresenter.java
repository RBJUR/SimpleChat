package com.example.roquebuarquejr.simplechat.registration.presenter;

/**
 * Created by roque
 */
public interface UserRegisterPresenter {
    void receiveRegisterRequest(String username, String email, String password);

    void onFailure(String message);

    void onSuccess(String uid);
}

package com.example.roquebuarquejr.simplechat.login.view;

/**
 * Created by roque
 */
public interface LoginView {
    void logTheUserIn(String username, String uid);
    void onFailure();
    void spinProgressBar();
    void stopProgressBar();
}

package com.example.roquebuarquejr.simplechat.login.view;

/**
 * Created by roque
 */
public interface LoginView {
    void logTheUserIn(String username, String uid, String emoji);
    void onFailure();
    void spinProgressBar();
    void stopProgressBar();
}

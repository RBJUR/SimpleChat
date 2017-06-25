package com.example.roquebuarquejr.simplechat.registration.view;

/**
 * Created by roque
 */
public interface RegisterView {
    void onSuccess();

    void onFailure();

    void spinProgressBar();

    void stopProgressBar();
}

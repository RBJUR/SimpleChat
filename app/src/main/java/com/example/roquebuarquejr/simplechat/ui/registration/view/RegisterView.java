package com.example.roquebuarquejr.simplechat.ui.registration.view;

/**
 * Created by roque
 */
public interface RegisterView {
    void onSuccess();

    void onFailure();

    void spinProgressBar();

    void stopProgressBar();
}

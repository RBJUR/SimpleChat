package com.example.roquebuarquejr.simplechat.ui.registration.view;

/**
 * Created by Filip on 23/02/2016.
 */
public interface RegisterView {
    void onSuccess();

    void onFailure();

    void spinProgressBar();

    void stopProgressBar();
}

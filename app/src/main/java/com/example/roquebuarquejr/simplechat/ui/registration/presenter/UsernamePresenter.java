package com.example.roquebuarquejr.simplechat.ui.registration.presenter;

/**
 * Created by roque
 */
public interface UsernamePresenter {
    void checkIfUsernameIsTaken(String username);
    void onUserAlreadyExists();
    void onUserDoesNotExist();
}

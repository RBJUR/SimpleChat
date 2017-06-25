package com.example.roquebuarquejr.simplechat.registration.presenter;

/**
 * Created by roque
 */
public interface UsernamePresenter {
    void checkIfUsernameIsTaken(String username);
    void onUserAlreadyExists();
    void onUserDoesNotExist();
}

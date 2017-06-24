package com.example.roquebuarquejr.simplechat.ui.registration.presenter;

/**
 * Created by Filip on 27/02/2016.
 */
public interface UsernamePresenter {
    void checkIfUsernameIsTaken(String username);
    void onUserAlreadyExists();
    void onUserDoesNotExist();
}

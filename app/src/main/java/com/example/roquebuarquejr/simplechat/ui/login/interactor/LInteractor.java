package com.example.roquebuarquejr.simplechat.ui.login.interactor;

import java.util.Map;

/**
 * Created by roque
 */
public interface LInteractor {
    void attemptToLogIn(String email, String password);

    Map<String, Object> createUser(String user, String emoji);

}

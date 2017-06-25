package com.example.roquebuarquejr.simplechat.registration.interactor;

import java.util.Map;

/**
 * Created by roque
 */
public interface RInteractor {
    void receiveRegisterRequest(String username, String email, String password, String emoji);
    Map<String, Object> createUser(String username, String emoji);
}

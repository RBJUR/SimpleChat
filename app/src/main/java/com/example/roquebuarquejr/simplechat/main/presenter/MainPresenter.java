package com.example.roquebuarquejr.simplechat.main.presenter;

/**
 * Created by roque
 */
public interface MainPresenter {
    void receiveRequest();
    String getNumberOfUsers(long numberOfUsers);
    void sendNumberOfChildren(long number);
}

package com.example.roquebuarquejr.simplechat.user.presenter;


import com.example.roquebuarquejr.simplechat.model.User;

import java.util.ArrayList;

/**
 * Created by roque
 */
public interface CurrentUsersPresenter {
    void getChildren(ArrayList<User> users);
    void request();
}
package com.example.roquebuarquejr.simplechat.user.presenter;


import com.example.roquebuarquejr.simplechat.model.User;

import java.util.ArrayList;

/**
 * Created by roque
 */
public interface UsersPresenter {
    void getChildren(ArrayList<User> users);
    void request();
}

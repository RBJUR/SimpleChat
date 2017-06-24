package com.example.roquebuarquejr.simplechat.ui.adapter.users;


import com.example.roquebuarquejr.simplechat.model.User;

import java.util.ArrayList;

/**
 * Created by Filip on 25/02/2016.
 */
public interface CurrentUsersPresenter {
    void getChildren(ArrayList<User> users);
    void request();
}

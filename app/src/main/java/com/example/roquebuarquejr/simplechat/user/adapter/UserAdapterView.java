package com.example.roquebuarquejr.simplechat.user.adapter;


import com.example.roquebuarquejr.simplechat.model.User;

import java.util.ArrayList;

/**
 * Created by roque
 */
public interface UserAdapterView {
    void addAll(ArrayList<User> users);
    void request();
}

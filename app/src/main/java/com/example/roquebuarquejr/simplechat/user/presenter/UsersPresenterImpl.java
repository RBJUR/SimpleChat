package com.example.roquebuarquejr.simplechat.user.presenter;


import com.example.roquebuarquejr.simplechat.model.User;
import com.example.roquebuarquejr.simplechat.user.adapter.UserAdapterView;
import com.example.roquebuarquejr.simplechat.user.interactor.UsersInteractor;

import java.util.ArrayList;

/**
 * Created by roque
 */
public class UsersPresenterImpl implements UsersPresenter {
    private final UserAdapterView adapterView;
    private final UsersInteractor interactor;


    public UsersPresenterImpl(UserAdapterView view) {
        this.adapterView = view;
        this.interactor = new UsersInteractor(this);
    }

    @Override
    public void getChildren(ArrayList<User> users) {
        adapterView.addAll(users);
    }

    @Override
    public void request(String userId) {
        interactor.request(userId);
    }

}

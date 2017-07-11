package com.example.roquebuarquejr.simplechat.user.presenter;


import com.example.roquebuarquejr.simplechat.model.User;
import com.example.roquebuarquejr.simplechat.user.adapter.UserAdapterView;
import com.example.roquebuarquejr.simplechat.user.interactor.CurrentUsersInteractor;

import java.util.ArrayList;

/**
 * Created by roque
 */
public class CurrentUsersPresenterImpl implements CurrentUsersPresenter {
    private final UserAdapterView adapterView;
    private final CurrentUsersInteractor interactor;


    public CurrentUsersPresenterImpl(UserAdapterView view) {
        this.adapterView = view;
        this.interactor = new CurrentUsersInteractor(this);
    }

    @Override
    public void getChildren(ArrayList<User> users) {
        adapterView.addAll(users);
    }

    @Override
    public void request() {
        interactor.request();
    }

}

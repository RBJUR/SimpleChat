package com.example.roquebuarquejr.simplechat.ui.registration.presenter;


import com.example.roquebuarquejr.simplechat.ui.registration.interactor.UsernameInteractor;
import com.example.roquebuarquejr.simplechat.ui.registration.view.UsernameFragmentView;

/**
 * Created by roque
 */
public class UsernamePresenterImpl implements UsernamePresenter {
    private final UsernameFragmentView usernameFragmentView;
    private final UsernameInteractor interactor;

    public UsernamePresenterImpl(UsernameFragmentView view) {
        this.usernameFragmentView = view;
        this.interactor = new UsernameInteractor(this);
    }

    @Override
    public void checkIfUsernameIsTaken(String username) {
        interactor.checkIfUsernameExists(username);
    }

    @Override
    public void onUserAlreadyExists() {
        usernameFragmentView.onFailure();
    }

    @Override
    public void onUserDoesNotExist() {
        usernameFragmentView.onSuccess();
    }
}

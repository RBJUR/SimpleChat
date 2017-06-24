package com.example.roquebuarquejr.simplechat.ui.login.presenter;


import com.example.roquebuarquejr.simplechat.ui.login.interactor.LoginInteractor;
import com.example.roquebuarquejr.simplechat.ui.login.view.LoginView;

/**
 * Created by roque
 */
public class FirebaseLoginPresenterImpl implements FirebaseLoginPresenter {
    private final LoginView loginView;
    private final LoginInteractor interactor;

    public FirebaseLoginPresenterImpl(LoginView view) {
        this.loginView = view;
        interactor = new LoginInteractor(this);
    }

    @Override
    public void receiveUserLogin(String email, String password) {
        loginView.spinProgressBar();
        interactor.attemptToLogIn(email, password);
    }

    @Override
    public void onFailure() {
        loginView.stopProgressBar();
        loginView.onFailure();
    }

    @Override
    public void onSuccess(String user, String uid, String emoji) {
        loginView.stopProgressBar();
        loginView.logTheUserIn(user, uid, emoji);
    }
}

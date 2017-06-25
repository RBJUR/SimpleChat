package com.example.roquebuarquejr.simplechat.registration.presenter;


import com.example.roquebuarquejr.simplechat.registration.interactor.RegisterInteractor;
import com.example.roquebuarquejr.simplechat.registration.view.RegisterView;

/**
 * Created by roque
 */
public class UserRegisterPresenterImpl implements UserRegisterPresenter {
    private final RegisterView registerView;
    private final RegisterInteractor interactor;

    public UserRegisterPresenterImpl(RegisterView view) {
        this.registerView = view;
        this.interactor = new RegisterInteractor(this);
    }


    @Override
    public void receiveRegisterRequest(String username, String email, String password, String emoji) {
        interactor.receiveRegisterRequest(username, email, password, emoji);
        registerView.spinProgressBar();
    }

    @Override
    public void onFailure() {
        registerView.onFailure();
        registerView.stopProgressBar();
    }

    @Override
    public void onSuccess() {
        registerView.onSuccess();
        registerView.stopProgressBar();
    }
}

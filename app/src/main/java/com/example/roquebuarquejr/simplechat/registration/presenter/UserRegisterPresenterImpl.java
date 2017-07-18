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
    public void receiveRegisterRequest(String username, String email, String password) {
        interactor.receiveRegisterRequest(username, email, password);
        registerView.showLoading(true);
    }

    @Override
    public void onFailure(String message) {
        registerView.onFailure(message);
        registerView.showLoading(false);
    }

    @Override
    public void onSuccess() {
        registerView.onSuccess();
        registerView.showLoading(false);
    }
}

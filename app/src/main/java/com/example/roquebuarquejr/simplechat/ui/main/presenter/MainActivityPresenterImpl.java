package com.example.roquebuarquejr.simplechat.ui.main.presenter;


import com.example.roquebuarquejr.simplechat.ui.main.interactor.MainInteractor;
import com.example.roquebuarquejr.simplechat.ui.main.view.MainView;

/**
 * Created by roque
 */
public class MainActivityPresenterImpl implements MainPresenter {
    private final MainView mainView;
    private final MainInteractor interactor;

    public MainActivityPresenterImpl(MainView view) {
        this.mainView = view;
        interactor = new MainInteractor(this);
    }


    @Override
    public void receiveRequest() {
        interactor.receiveRequest();
    }

    @Override
    public String getNumberOfUsers(long numberOfUsers) {
        return "Online users: " + String.valueOf(numberOfUsers);
    }

    @Override
    public void sendNumberOfChildren(long number) {
        mainView.setNumberOfUsersTextView(getNumberOfUsers(number));
    }
}

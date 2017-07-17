package com.example.roquebuarquejr.simplechat.chat.presenter;


import com.example.roquebuarquejr.simplechat.chat.adapter.MessageAdapterView;
import com.example.roquebuarquejr.simplechat.chat.interactor.MessageInteractor;
import com.example.roquebuarquejr.simplechat.model.Message;

/**
 * Created by roque
 */
public class MessagePresenterImpl implements MessagePresenter {
    private  MessageAdapterView adapterView;
    private  MessageInteractor interactor;

    public MessagePresenterImpl(MessageAdapterView view) {
        this.adapterView = view;
        this.interactor = new MessageInteractor(this);
    }

    public MessagePresenterImpl() {
        this.interactor = new MessageInteractor(this);
    }



    @Override
    public void sendMessageToAdapter(Message message) {
        adapterView.addItem(message);

    }

    @Override
    public void requestMessages(String id, String myUid) {
        interactor.request(id, myUid);
    }

    @Override
    public void sendMessage(String author, String message, String id, String myUid) {
        interactor.pushMessageToFirebase(author, message, id, myUid);
    }

    @Override
    public void scrollRecyclerView(int position) {

    }
}

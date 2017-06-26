package com.example.roquebuarquejr.simplechat.chat.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.chat.adapter.CustomMessageRecyclerAdapter;
import com.example.roquebuarquejr.simplechat.chat.adapter.MessageAdapterView;
import com.example.roquebuarquejr.simplechat.chat.adapter.MessagePresenterImpl;
import com.example.roquebuarquejr.simplechat.chat.presenter.ChatMessagePresenterImpl;
import com.example.roquebuarquejr.simplechat.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roque
 */
public class ChatFragment extends Fragment implements View.OnClickListener, MessageAdapterView {
    private RecyclerView mMessagesListView;
    private EditText mEnterMessageEditText;
    private ImageButton mSendMessageButton;
    private CustomMessageRecyclerAdapter adapter;
    private ChatMessagePresenterImpl presenter;
    private List<Message> mMessageList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_service, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createUI(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        fillUI();
    }

    @Override
    public void onClick(View v) {
        handleMessageClick();
    }

    private void createUI(View view) {
        mMessagesListView = (RecyclerView) view.findViewById(R.id.chat_recycler_view);
        mEnterMessageEditText = (EditText) view.findViewById(R.id.chat_edit_text);
        mSendMessageButton = (ImageButton) view.findViewById(R.id.chat_send_button);
        mSendMessageButton.setOnClickListener(this);
        request();

    }

    private void fillUI() {
        presenter = new ChatMessagePresenterImpl(this);
    }

    private void populateList() {
        adapter = new CustomMessageRecyclerAdapter(getActivity().getIntent().getStringExtra("username"), mMessageList);
        mMessagesListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMessagesListView.setHasFixedSize(true);
        mMessagesListView.setItemAnimator(new DefaultItemAnimator());
        mMessagesListView.setAdapter(adapter);
        mMessagesListView.scrollToPosition(adapter.getItemCount());
    }

    private void handleMessageClick() {
        presenter.sendMessage(getActivity().getIntent().getStringExtra("username"), mEnterMessageEditText.getText().toString(), getActivity().getIntent().getStringExtra("emoji"));
        mEnterMessageEditText.setText("");
    }

    @Override
    public void addItem(Message message) {
        mMessageList.add(message);
        populateList();
    }

    @Override
    public void request() {
        presenter.requestMessages();
    }

    @Override
    public void listMessages(List<Message> messages) {
        mMessageList = messages;
        populateList();
    }
}

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
import com.example.roquebuarquejr.simplechat.chat.presenter.ChatMessagePresenterImpl;

/**
 * Created by roque
 */
public class ChatFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_USER_NAME = "ARG_USER_NAME";

    private RecyclerView mMessagesListView;
    private EditText mEnterMessageEditText;
    private ImageButton mSendMessageButton;
    private CustomMessageRecyclerAdapter adapter;
    private ChatMessagePresenterImpl presenter;

    public static ChatFragment newInstance(String userName){
        ChatFragment fragment = new ChatFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_USER_NAME, userName);
        fragment.setArguments(bundle);
        return  fragment;

    }

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
    }

    private void fillUI() {
        adapter = new CustomMessageRecyclerAdapter(getActivity().getIntent().getStringExtra("username"));
        adapter.request();
        mMessagesListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMessagesListView.setHasFixedSize(true);
        mMessagesListView.setItemAnimator(new DefaultItemAnimator());
        mMessagesListView.setAdapter(adapter);
        presenter = new ChatMessagePresenterImpl();
    }

    private void handleMessageClick() {
        presenter.sendMessage(getActivity().getIntent().getStringExtra("username"), mEnterMessageEditText.getText().toString(), "");
        mEnterMessageEditText.setText("");
        mMessagesListView.scrollToPosition(mMessagesListView.getBottom());
    }
}

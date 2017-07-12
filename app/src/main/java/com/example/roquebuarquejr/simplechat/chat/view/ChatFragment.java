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
    private static final String ARG_USER_ID = "ARG_USER_ID";

    private RecyclerView recyclerView;
    private EditText txtMessage;
    private ImageButton btnSend;
    private CustomMessageRecyclerAdapter adapter;
    private ChatMessagePresenterImpl presenter;

    public static ChatFragment newInstance(String userName, String uid){
        ChatFragment fragment = new ChatFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_USER_NAME, userName);
        bundle.putString(ARG_USER_ID, uid);
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
        recyclerView = (RecyclerView) view.findViewById(R.id.chat_recycler_view);
        txtMessage = (EditText) view.findViewById(R.id.chat_edit_text);
        btnSend = (ImageButton) view.findViewById(R.id.chat_send_button);
        btnSend.setOnClickListener(this);
    }

    private void fillUI() {
        adapter = new CustomMessageRecyclerAdapter(getArguments().getString(ARG_USER_NAME));
        adapter.request();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        presenter = new ChatMessagePresenterImpl();
    }

    private void handleMessageClick() {
        presenter.sendMessage(getArguments().getString(ARG_USER_NAME), txtMessage.getText().toString(), getArguments().getString(ARG_USER_ID));
        txtMessage.setText("");
        recyclerView.scrollToPosition(recyclerView.getBottom());
    }
}

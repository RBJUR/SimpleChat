package com.example.roquebuarquejr.simplechat.chat.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.chat.adapter.CustomMessageRecyclerAdapter;
import com.example.roquebuarquejr.simplechat.chat.presenter.MessagePresenterImpl;

/**
 * Created by roque
 */
public class ChatFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_USER_NAME = "ARG_USER_NAME";
    private static final String ARG_USER_ID = "ARG_USER_ID";
    private static final String ARG_USER_MY_ID = "ARG_USER_MY_ID";

    private RecyclerView recyclerView;
    private EditText txtMessage;
    private ImageButton btnSend;
    private CustomMessageRecyclerAdapter adapter;
    private MessagePresenterImpl presenter;

    public static ChatFragment newInstance(String userName, String uid, String myUid) {
        ChatFragment fragment = new ChatFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_USER_NAME, userName);
        bundle.putString(ARG_USER_ID, uid);
        bundle.putString(ARG_USER_MY_ID, myUid);
        fragment.setArguments(bundle);
        return fragment;

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
        getActivity().setTitle(getArguments().getString(ARG_USER_NAME));
    }

    private void fillUI() {
        adapter = new CustomMessageRecyclerAdapter(getArguments().getString(ARG_USER_NAME));
        adapter.request(getArguments().getString(ARG_USER_ID), getArguments().getString(ARG_USER_MY_ID));
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        presenter = new MessagePresenterImpl();

        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right,int bottom, int oldLeft, int oldTop,int oldRight, int oldBottom)
            {
                recyclerView.scrollToPosition(adapter.getItemCount()  > 1 ? adapter.getItemCount() - 1 : 0);
            }
        });

        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                recyclerView.smoothScrollToPosition(adapter.getItemCount()  > 1 ? adapter.getItemCount() - 1 : 0);
            }
        });

    }

    private void handleMessageClick() {
        presenter.sendMessage(getArguments().getString(ARG_USER_NAME), txtMessage.getText().toString(), getArguments().getString(ARG_USER_ID), getArguments().getString(ARG_USER_MY_ID));
        txtMessage.setText("");
        //recyclerView.scrollToPosition(recyclerView.getBottom());

    }

}

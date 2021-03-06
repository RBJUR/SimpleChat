package com.example.roquebuarquejr.simplechat.chat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.chat.presenter.MessagePresenterImpl;
import com.example.roquebuarquejr.simplechat.model.Message;

import java.util.ArrayList;

/**
 * Created by roque
 */
public class CustomMessageRecyclerAdapter extends RecyclerView.Adapter<CustomMessageRecyclerAdapter.ViewHolder> implements MessageAdapterView {
    private final ArrayList<Message> mMessageList = new ArrayList<>();
    private final String user;
    private final MessagePresenterImpl presenter;

    public CustomMessageRecyclerAdapter(String username) {
        this.user = username;
        presenter = new MessagePresenterImpl(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_message, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message current = mMessageList.get(position);
        if (current.getAuthor().equals(user)) {
            holder.mAuthorTextView.setText("You");
        } else {
            holder.mAuthorTextView.setText(current.getAuthor());
        }
        holder.mMessageTextView.setText(current.getMessage());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }


    @Override
    public void addItem(Message message) {
        mMessageList.add(message);
        notifyDataSetChanged();
    }

    @Override
    public void request(String id, String myUid) {
        presenter.requestMessages(id,myUid);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mAuthorTextView;
        private TextView mMessageTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mAuthorTextView = (TextView) itemView.findViewById(R.id.message_author);
            mMessageTextView = (TextView) itemView.findViewById(R.id.message_value);
        }
    }
}

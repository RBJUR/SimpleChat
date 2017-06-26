package com.example.roquebuarquejr.simplechat.chat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roque
 */
public class CustomMessageRecyclerAdapter extends RecyclerView.Adapter<CustomMessageRecyclerAdapter.ViewHolder> {
    private List<Message> mMessageList = new ArrayList<>();
    private final String user;

    public CustomMessageRecyclerAdapter(String username, List<Message> messages) {
        this.user = username;
        mMessageList = messages;
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
        holder.mEmojiTextView.setText(current.getEmoji());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mAuthorTextView;
        private TextView mMessageTextView;
        private TextView mEmojiTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mAuthorTextView = (TextView) itemView.findViewById(R.id.message_author);
            mMessageTextView = (TextView) itemView.findViewById(R.id.message_value);
            mEmojiTextView = (TextView) itemView.findViewById(R.id.message_emoji);
        }
    }
}

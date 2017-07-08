package com.example.roquebuarquejr.simplechat.user.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.model.User;
import com.example.roquebuarquejr.simplechat.user.presenter.UsersPresenterImpl;

import java.util.ArrayList;

/**
 * Created by roque
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> implements UserAdapterView {
    private final ArrayList<User> mUserList = new ArrayList<>();
    private final UsersPresenterImpl presenter;

    public UsersAdapter() {
        this.presenter = new UsersPresenterImpl(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User current = mUserList.get(position);
        holder.mUserTextView.setText(current.getUsername());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    @Override
    public void addAll(ArrayList<User> users) {
        mUserList.clear();
        mUserList.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public void request() {
        presenter.request();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mUserTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mUserTextView = (TextView) itemView.findViewById(R.id.user_item_text_view);
        }
    }
}

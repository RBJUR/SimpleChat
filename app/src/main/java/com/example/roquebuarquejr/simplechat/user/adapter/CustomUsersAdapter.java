package com.example.roquebuarquejr.simplechat.user.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.model.User;
import com.example.roquebuarquejr.simplechat.user.presenter.CurrentUsersPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roque
 */

public class CustomUsersAdapter extends RecyclerView.Adapter<CustomUsersAdapter.ViewHolder>  {

    private final View.OnClickListener onClickListener;
    private List<User> mUserList;

    public CustomUsersAdapter(List<User> userList, View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.mUserList = userList;
        notifyDataSetChanged();

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


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mUserTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mUserTextView = (TextView) itemView.findViewById(R.id.user_item_text_view);
        }
    }
}

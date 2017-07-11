package com.example.roquebuarquejr.simplechat.user.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.roquebuarquejr.simplechat.R;
import com.example.roquebuarquejr.simplechat.model.User;

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
        holder.txtUserName.setText(current.getUsername());
        holder.txtUserEmail.setText(current.getUseremail());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtUserName;
        private TextView txtUserEmail;
        private LinearLayout ctnMain;

        public ViewHolder(View itemView) {
            super(itemView);
            txtUserName = (TextView) itemView.findViewById(R.id.user_item_txt_name);
            txtUserEmail = (TextView) itemView.findViewById(R.id.user_item_txt_email);
            ctnMain = (LinearLayout) itemView.findViewById(R.id.main);
            ctnMain.setOnClickListener(onClickListener);
        }
    }
}

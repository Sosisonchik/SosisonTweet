package com.company.sosison.sosisontweet.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.company.sosison.sosisontweet.R;
import com.company.sosison.sosisontweet.pojo.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {
    List<User> usersList = new ArrayList<>();

    public void add(User user){
        usersList.add(user);
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_view,parent,false);
        return new UsersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final UsersViewHolder holder, final int position) {
        holder.bind(usersList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),"name "+usersList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    public class UsersViewHolder extends RecyclerView.ViewHolder {
        public void bind(User user){
            name.setText(user.getName());
            nick.setText(user.getNick());
            Picasso.with(itemView.getContext()).load(user.getImageUri()).into(userImage);
        }

        private TextView name;
        private TextView nick;
        private CircleImageView userImage;
        public UsersViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_image_item);
            name = itemView.findViewById(R.id.user_name_search);
            nick = itemView.findViewById(R.id.user_nick_search);
        }
    }
}

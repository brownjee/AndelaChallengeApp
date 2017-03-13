package com.brownjee.andelachallengeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brownjee.andelachallengeapp.DevelopersDetails;
import com.brownjee.andelachallengeapp.R;
import com.brownjee.andelachallengeapp.model.User;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Brownjee on 3/13/2017.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<User> userList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView user_profile_avatar;
        TextView username, user_state;


        public MyViewHolder(View view) {
            super(view);
            user_profile_avatar = (CircleImageView) view.findViewById(R.id.profile_image);
            username = (TextView) view.findViewById(R.id.user_name);
            user_state = (TextView) view.findViewById(R.id.userstate);

        }
    }


    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.developers_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final User user = userList.get(position);

        holder.username.setText(user.getLogin());
        holder.user_state.setText("Lagos");


        //Loading the image using Glide
        Context context = holder.user_profile_avatar.getContext();
        Glide.with(context).load(user.getAvatarUrl()).into(holder.user_profile_avatar);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DevelopersDetails.class);
                intent.putExtra("user", user);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
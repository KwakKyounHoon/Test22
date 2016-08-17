package com.didimdol.kwak.test.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.data.Profile;

/**
 * Created by Kwak on 2016-08-17.
 */
public class MenuProfileViewHolder extends RecyclerView.ViewHolder {
    TextView nameView;
    ImageView profieImageView;
    TextView emailView;

    public MenuProfileViewHolder(View itemView) {
        super(itemView);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        profieImageView = (ImageView)itemView.findViewById(R.id.image_photo);
        emailView = (TextView)itemView.findViewById(R.id.text_email);
    }

    Profile profile;

    public void setProfile(Profile profile){
        this.profile = profile;
        nameView.setText(profile.getName());
        emailView.setText(profile.getEmail());
    }
}

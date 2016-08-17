package com.didimdol.kwak.test.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Kwak on 2016-08-17.
 */
public class Profile {
    private Drawable profileImage;
    private String name;
    private String email;

    public Drawable getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Drawable profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

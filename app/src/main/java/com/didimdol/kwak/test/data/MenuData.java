package com.didimdol.kwak.test.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kwak on 2016-08-17.
 */
public class MenuData {
    private Profile profile;
    List<Menuitem> items = new ArrayList<>();

    public MenuData(){

    }


    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Menuitem> getItems() {
        return items;
    }

    public void setItems(List<Menuitem> items) {
        this.items = items;
    }
}

package com.didimdol.kwak.test.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Kwak on 2016-08-17.
 */
public class Menuitem {
    private Drawable iconImage;
    private int menuCode;

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getIconName() {
        return iconName;
    }

    public Menuitem(Drawable iconImage, String iconName, int menuCode) {
        this.iconImage = iconImage;
        this.iconName = iconName;
        this.menuCode = menuCode;
    }
    public Menuitem(){

    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public Drawable getIconImage() {
        return iconImage;
    }

    public void setIconImage(Drawable iconImage) {
        this.iconImage = iconImage;
    }

    private String iconName;
}

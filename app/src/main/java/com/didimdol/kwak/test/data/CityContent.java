package com.didimdol.kwak.test.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-08-20.
 */
public class CityContent {
    private Drawable cityImage;
    private String name, count, house;

    public Drawable getCityImage() {
        return cityImage;
    }

    public void setCityImage(Drawable cityImage) {
        this.cityImage = cityImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}

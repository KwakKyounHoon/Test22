package com.didimdol.kwak.test.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-08-20.
 */
public class CityContents {
    private String name;

    private List<CityContent> cityContent = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityContent> getCityContent() {
        return cityContent;
    }

    public void setCityContent(List<CityContent> cityContent) {
        this.cityContent = cityContent;
    }
}

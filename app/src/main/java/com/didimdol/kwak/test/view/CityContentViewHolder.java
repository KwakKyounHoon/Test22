package com.didimdol.kwak.test.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.didimdol.kwak.test.data.Category;

/**
 * Created by Tacademy on 2016-08-20.
 */
public class CityContentViewHolder extends RecyclerView.ViewHolder {

    Category category;
    TextView category_name;

    public CityContentViewHolder(View itemView) {
        super(itemView);
    }


}

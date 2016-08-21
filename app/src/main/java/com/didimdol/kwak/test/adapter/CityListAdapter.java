package com.didimdol.kwak.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.data.CityContents;
import com.didimdol.kwak.test.view.CityContentViewHolder;
import com.didimdol.kwak.test.view.TextViewHolder;

/**
 * Created by Kwak on 2016-08-21.
 */
public class CityListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    CityContents cityContents;
    Context context;

    private static final int VIEW_TYPE_CATEGORY = 1;
    private static final int VIEW_TYPE_CIRTITEMS = 2;

    public CityListAdapter(Context context){
        this.context = context;
    }

    public CityListAdapter(){

    }

    public void addCityContents(CityContents cityContents) {
        this.cityContents = cityContents;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_CATEGORY;
        }
        position--;
        if (cityContents.getCityContent().size() > 0) {
            if (position < cityContents.getCityContent().size()) {
                return VIEW_TYPE_CIRTITEMS;
            }
            position -= 1;
        }

        //배열 인덱스 예외가 발생할 수 있으니 예외처리.//
        throw new IllegalArgumentException(("Invalid position"));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_CATEGORY :{
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_text, parent, false);
                TextViewHolder holder = new TextViewHolder(view);
                return holder;
            }
            case VIEW_TYPE_CIRTITEMS : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_city_content, parent, false);
                CityContentViewHolder holder = new CityContentViewHolder(view,context);
                return holder;
            }
        }
        throw new IllegalArgumentException("invalid viewtype");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            TextViewHolder tvh = (TextViewHolder)holder;
            tvh.setText(cityContents.getName());
            return;
        }
        position--;
        if (cityContents.getCityContent().size() > 0) {
            if (position < cityContents.getCityContent().size()) {
                CityContentViewHolder ccvh = (CityContentViewHolder)holder;
                ccvh.setCityContent(cityContents.getCityContent().get(position));
                return;
            }
            position -= 1;
        }
        //배열 인덱스 예외가 발생할 수 있으니 예외처리.//
        throw new IllegalArgumentException(("Invalid position"));
    }


    @Override
    public int getItemCount() {
        if(cityContents == null) {
            return 0;
        }
        int count = 0;
        if(cityContents.getName() != null) count++;
        if(cityContents.getCityContent() != null) count += cityContents.getCityContent().size();

        return count;
    }


}

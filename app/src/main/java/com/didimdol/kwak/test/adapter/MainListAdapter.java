package com.didimdol.kwak.test.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.data.MainData;
import com.didimdol.kwak.test.view.CategoryViewHolder;
import com.didimdol.kwak.test.view.HostRecommendViewHolder;
import com.didimdol.kwak.test.view.ImageSliderViewHolder;
import com.didimdol.kwak.test.view.MainTextViewHolder;


/**
 * Created by Kwak on 2016-08-14.
 */
public class MainListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    MainData mainData;

    private static final int VIEW_TYPE_CATEGORY_TITLE_SEARCH = 10;
    private static final int VIEW_TYPE_CATEGORY_TITLE_HOSTCOMMEND = 11;
    private static final int VIEW_TYPE_CATEGORY_TITLE_WEEKCOMMEND = 12;
    private static final int VIEW_TYPE_CATEGORY_TITLE_AIRBNBCOMMENT = 13;

    private static final int VIEW_TYPE_MAIN_INFO = 0;
    private static final int VIEW_TYPE_SEARCH = 1;
    private static final int VIEW_TYPE_HOSTCOMMEND = 2;
    private static final int VIEW_TYPE_WEEKCOMMEND = 3;
    private static final int VIEW_TYPE_AIRBNBCOMMENT = 4;

    FragmentManager fragmentManager;
    Context context;

    public MainListAdapter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public MainListAdapter(FragmentManager fragmentManager, Context context) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public MainListAdapter(Context context) {
        this.context = context;
    }

    public void setmainData(MainData mainData) {
        if(this.mainData != mainData) {
            this.mainData = mainData;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_MAIN_INFO;
        }
        position--;
        if (mainData.getSearchImage() != null) {
            if (position == 0){
                return VIEW_TYPE_CATEGORY_TITLE_SEARCH;
            }
            position--;
            if (position == 0) {
                return VIEW_TYPE_SEARCH;
            }
            position -= 1;
        }

        if (mainData.getHostCommend() != null) {
            if (position == 0){
                return VIEW_TYPE_CATEGORY_TITLE_HOSTCOMMEND;
            }
            position--;
            if (position == 0) {
                return VIEW_TYPE_HOSTCOMMEND;
            }
            position -= 1;
        }

        if (mainData.getWeekCommend() != null) {
            if (position == 0){
                return VIEW_TYPE_CATEGORY_TITLE_WEEKCOMMEND;
            }
            position--;
            if (position == 0) {
                return VIEW_TYPE_WEEKCOMMEND;
            }
            position -= 1;
        }

        if (mainData.getAirBnBCommend() != null) {
            if (position == 0){
                return VIEW_TYPE_CATEGORY_TITLE_AIRBNBCOMMENT;
            }
            position--;
            if (position == 0) {
                return VIEW_TYPE_AIRBNBCOMMENT;
            }
            position -= 1;
        }

        //배열 인덱스 예외가 발생할 수 있으니 예외처리.//
        throw new IllegalArgumentException(("Invalid position"));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_MAIN_INFO :{
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_main_name, parent, false);
                MainTextViewHolder holder = new MainTextViewHolder(view);
                return holder;
            }
            case VIEW_TYPE_SEARCH : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_searchimage_slider, parent, false);
//                SearchSliderViewHolder holder = new SearchSliderViewHolder(view,fragmentManager);
                ImageSliderViewHolder holder = new ImageSliderViewHolder(view, context);
                return holder;
            }
            case VIEW_TYPE_CATEGORY_TITLE_SEARCH : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category, parent, false);
                CategoryViewHolder holder = new CategoryViewHolder(view);
                return holder;
            }
            case VIEW_TYPE_CATEGORY_TITLE_HOSTCOMMEND : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category, parent, false);
                CategoryViewHolder holder = new CategoryViewHolder(view);
                return holder;
            }
            case VIEW_TYPE_HOSTCOMMEND : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_host_commend, parent, false);
                HostRecommendViewHolder holder = new HostRecommendViewHolder(view);
                return holder;
            }
            case VIEW_TYPE_WEEKCOMMEND : {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_weekcommend_slider, parent, false);
//                WeekComendViewHolder holder = new WeekComendViewHolder(view,fragmentManager);
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_searchimage_slider, parent, false);
                ImageSliderViewHolder holder = new ImageSliderViewHolder(view, context);
                return holder;
            }
            case VIEW_TYPE_CATEGORY_TITLE_WEEKCOMMEND : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category, parent, false);
                CategoryViewHolder holder = new CategoryViewHolder(view);
                return holder;
            }
            case VIEW_TYPE_AIRBNBCOMMENT : {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_airbnbcommend_slider, parent, false);
//                AirBnBCommendViewHoler holder = new AirBnBCommendViewHoler(view,fragmentManager);
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_searchimage_slider, parent, false);
                ImageSliderViewHolder holder = new ImageSliderViewHolder(view, context);
                return holder;
            }
            case VIEW_TYPE_CATEGORY_TITLE_AIRBNBCOMMENT : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category, parent, false);
                CategoryViewHolder holder = new CategoryViewHolder(view);
                return holder;
            }
        }
        throw new IllegalArgumentException("invalid viewtype");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            MainTextViewHolder mtv = (MainTextViewHolder)holder;
            mtv.setMainText(mainData);
            return;
        }
        position--;
        if (mainData.getSearchImage() != null) {
            if (position == 0){
                CategoryViewHolder cvh = (CategoryViewHolder)holder;
                cvh.setCategory("최근 검색 기록");
                return;
            }
            position--;
            if (position == 0) {
//                SearchSliderViewHolder isvh = (SearchSliderViewHolder)holder;
                ImageSliderViewHolder isvh = (ImageSliderViewHolder)holder;
                isvh.setImageData(mainData.getSearchImage());
                return ;
            }
            position -= 1;
        }
        if (mainData.getHostCommend() != null) {
            if (position == 0){
                CategoryViewHolder cvh = (CategoryViewHolder)holder;
                cvh.setCategory("호스트가 되세요");
                return;
            }
            position--;
            if (position == 0) {
                HostRecommendViewHolder hrvh = (HostRecommendViewHolder)holder;
                hrvh.setHostCommend(mainData.getHostCommend());
                return ;
            }
            position -= 1;
        }
        if (mainData.getWeekCommend() != null) {
            if (position == 0){
                CategoryViewHolder cvh = (CategoryViewHolder)holder;
                cvh.setCategory("주말 여행 추천 도시");
                return;
            }
            position--;
            if (position == 0) {
//                WeekComendViewHolder wcvh = (WeekComendViewHolder)holder;
                ImageSliderViewHolder wcvh = (ImageSliderViewHolder)holder;
                wcvh.setImageData(mainData.getWeekCommend());
                return ;
            }
            position -= 1;
        }
        if (mainData.getWeekCommend() != null) {
            if (position == 0){
                CategoryViewHolder cvh = (CategoryViewHolder)holder;
                cvh.setCategory("에어비앤비 추천");
                return;
            }
            position--;
            if (position == 0) {
//                AirBnBCommendViewHoler wcvh = (AirBnBCommendViewHoler)holder;
                ImageSliderViewHolder wcvh = (ImageSliderViewHolder)holder;
                wcvh.setImageData(mainData.getAirBnBCommend());
                return ;
            }
            position -= 1;
        }
        //배열 인덱스 예외가 발생할 수 있으니 예외처리.//
        throw new IllegalArgumentException(("Invalid position"));
    }

    @Override
    public int getItemCount() {
        if(mainData == null) {
            return 0;
        }
        int count = 0;
        count++;
        if(mainData.getSearchImage() != null) {
            count += 2;
        }
        if(mainData.getHostCommend() != null) {
            count += 2;
        }
        if(mainData.getWeekCommend() != null) {
            count += 2;
        }
        if(mainData.getAirBnBCommend() != null) {
            count += 2;
        }
        return count;
    }
}

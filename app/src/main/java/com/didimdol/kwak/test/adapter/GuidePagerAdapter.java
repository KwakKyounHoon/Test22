package com.didimdol.kwak.test.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.didimdol.kwak.test.data.ImageData;
import com.didimdol.kwak.test.data.ImageDatas;
import com.didimdol.kwak.test.view.GuidePagerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kwak on 2016-08-19.
 */
public class GuidePagerAdapter extends PagerAdapter {
    List<ImageData> items = new ArrayList<>();
    ImageDatas datas = new ImageDatas();

    Context mContext;

    public GuidePagerAdapter(Context context) {
        mContext = context;
    }

    public void add(ImageDatas datas) {
        this.items = datas.getImageDatas();
        notifyDataSetChanged();
    }

//    public void add(ImageDatas items) {
//        this.items = items.getImagedatas();
//        notifyDataSetChanged();
//    }

//    public void add(String text) {
//        items.add(text);
//        notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
        return items.size();
    }

    List<GuidePagerView> scrapped = new ArrayList<>();

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        GuidePagerView guidePagerView = null;
        if (scrapped.size() > 0) {
            guidePagerView = scrapped.remove(0);
        } else {
            guidePagerView = new GuidePagerView(mContext);
        }
        guidePagerView.setImageData(items.get(position));
        container.addView(guidePagerView);
        return guidePagerView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
        scrapped.add((GuidePagerView) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.5f;
    }
}
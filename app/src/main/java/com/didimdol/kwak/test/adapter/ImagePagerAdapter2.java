package com.didimdol.kwak.test.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.didimdol.kwak.test.data.ImageData;
import com.didimdol.kwak.test.data.ImageDatas;
import com.didimdol.kwak.test.view.ImagePagerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kwak on 2016-08-14.
 */
public class ImagePagerAdapter2 extends PagerAdapter {
    List<ImageData> items = new ArrayList<>();
    ImageDatas datas = new ImageDatas();

    Context mContext;

    public ImagePagerAdapter2(Context context) {
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

    List<ImagePagerView> scrapped = new ArrayList<>();

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImagePagerView imagePagerView = null;
        if (scrapped.size() > 0) {
            imagePagerView = scrapped.remove(0);
        } else {
            imagePagerView = new ImagePagerView(mContext);
        }
        imagePagerView.setImageData(items.get(position));
//        tv.setText(items.get(position));
        container.addView(imagePagerView);
        return imagePagerView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
        scrapped.add((ImagePagerView)view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public float getPageWidth(int position) {
        return 1.0f;
    }
}

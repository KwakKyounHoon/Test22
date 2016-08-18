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
public class ImagePagerAdapter extends PagerAdapter implements ImagePagerView.OnItemClickListener {
    List<ImageData> items = new ArrayList<>();
    ImageDatas datas = new ImageDatas();

    Context mContext;

    public ImagePagerAdapter(Context context) {
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
        container.addView(imagePagerView);
        imagePagerView.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(View view, ImageData imageData) {
        if(listener != null){
            listener.onAdapterItemClick(view, imageData);
        }
    }

    public interface OnAdapterItemClickLIstener {
        public void onAdapterItemClick(View view, ImageData imageData);
    }

    OnAdapterItemClickLIstener listener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickLIstener listener) {
        this.listener = listener;
    }


}

package com.didimdol.kwak.test.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.RoundedAvatarDrawable;
import com.didimdol.kwak.test.data.CityContent;

/**
 * Created by Kwak on 2016-08-21.
 */
public class CityContentViewHolder extends RecyclerView.ViewHolder {

    CityContent cityContent;
    TextView nameView, countView, houseView;
    RatingBar ratingBar;
    ImageView cityView, heartView, profileView;
    Context context;

    public CityContentViewHolder(View itemView,Context context) {
        super(itemView);
        this.context = context;
        cityView = (ImageView)itemView.findViewById(R.id.image_city);
        heartView = (ImageView)itemView.findViewById(R.id.image_heart);
        countView = (TextView)itemView.findViewById(R.id.text_view);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        houseView = (TextView)itemView.findViewById(R.id.text_house);
        ratingBar = (RatingBar)itemView.findViewById(R.id.ratingBar);
        profileView = (ImageView)itemView.findViewById(R.id.image_profile);
    }

    public void setCityContent(CityContent cityContent){
        this.cityContent = cityContent;
        cityView.setImageDrawable(cityContent.getCityImage());
        countView.setText(cityContent.getCount());
        nameView.setText(cityContent.getName());
        houseView.setText(cityContent.getHouse());
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.dd);
        RoundedAvatarDrawable drawable = new RoundedAvatarDrawable(bitmap);
        profileView.setImageDrawable(cityContent.getCityImage());
        profileView.setImageDrawable(drawable);
        ratingBar.setStepSize((float) 0.5);        //별 색깔이 1칸씩줄어들고 늘어남 0.5로하면 반칸씩 들어감
        ratingBar.setRating((float)3.5);      // 처음보여줄때(색깔이 한개도없음) default 값이 0  이다
        ratingBar.setIsIndicator(true);
    }
}

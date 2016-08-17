package com.didimdol.kwak.test.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.data.ImageData;

/**
 * Created by Kwak on 2016-08-18.
 */
public class ImagePagerView extends FrameLayout {

    ImageView pagerImage;
    TextView nameView;

    public ImagePagerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_item_image, this);
        pagerImage = (ImageView)findViewById(R.id.image_pager);
        nameView = (TextView)findViewById(R.id.image_name);
    }

    ImageData imageData;

    public void setImageData(ImageData imageData){
        this.imageData = imageData;
        pagerImage.setImageDrawable(ContextCompat.getDrawable(getContext(),imageData.getImageId()));
        nameView.setText(imageData.getImageName());
    }
}

package com.didimdol.kwak.test.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.data.ImageData;

/**
 * Created by Kwak on 2016-08-18.
 */
public class ImagePagerView extends RelativeLayout {

    ImageView pagerImage;
    TextView nameView;
    View view;

    public ImagePagerView(Context context) {
        super(context);
        init();
    }

    OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, ImageData imageData);
    }


    private void init() {
        view = inflate(getContext(), R.layout.view_item_image, this);
        pagerImage = (ImageView)findViewById(R.id.image_pager);
        nameView = (TextView)findViewById(R.id.image_name);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) listener.onItemClick(view, imageData);
            }
        });
    }

    ImageData imageData;

    public void setImageData(ImageData imageData){
        this.imageData = imageData;
        pagerImage.setImageDrawable(ContextCompat.getDrawable(getContext(),imageData.getImageId()));
        nameView.setText(imageData.getImageName());
    }
}

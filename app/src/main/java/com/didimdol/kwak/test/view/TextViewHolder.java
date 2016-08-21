package com.didimdol.kwak.test.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.didimdol.kwak.test.R;

/**
 * Created by Administrator on 2016-07-27.
 */
public class TextViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public TextViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.name);
    }

    public void setText(String text) {
        textView.setText(text);
    }
}

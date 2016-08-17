package com.didimdol.kwak.test.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.data.Menuitem;

/**
 * Created by Kwak on 2016-08-17.
 */
public class MenuItemViewHolder extends RecyclerView.ViewHolder {
    TextView nameView;
    ImageView iconView;

    OnMenuItemClickListener listener;
    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnMenuItemClickListener {
        public void onMenuItemClick(View view, Menuitem menuitem , int position);
    }

    public MenuItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onMenuItemClick(view, menuitem, getAdapterPosition());
                }
            }
        });
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        iconView = (ImageView)itemView.findViewById(R.id.image_icon);
    }

    Menuitem menuitem;

    public void setMenuitem(Menuitem menuitem){
        this.menuitem = menuitem;
        nameView.setText(menuitem.getIconName());
        iconView.setImageDrawable(menuitem.getIconImage());
    }
}

package com.didimdol.kwak.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.data.MenuData;
import com.didimdol.kwak.test.data.Menuitem;
import com.didimdol.kwak.test.view.MenuItemViewHolder;
import com.didimdol.kwak.test.view.MenuProfileViewHolder;

/**
 * Created by Kwak on 2016-08-16.
 */
public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MenuItemViewHolder.OnMenuItemClickListener{

    MenuData menuData;

    public void addData(MenuData menuData){
        this.menuData = menuData;
        notifyDataSetChanged();;
    }

    private static final int VIEW_TYPE_PROFILE= 1;
    private static final int VIEW_TYPE_MENU_ITEM = 2;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_PROFILE;
        }
        position--;
        if (menuData.getItems().size() > 0) {
            if (position < menuData.getItems().size()) {
                return VIEW_TYPE_MENU_ITEM;
            }
            position -= menuData.getItems().size();
        }
        throw new IllegalArgumentException(("Invalid position"));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_PROFILE :{
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_profile, parent, false);
                MenuProfileViewHolder holder = new MenuProfileViewHolder(view);
                return holder;
            }
            case VIEW_TYPE_MENU_ITEM : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_menuitem, parent, false);
                MenuItemViewHolder holder = new MenuItemViewHolder(view);
                    holder.setOnMenuItemClickListener(this);
                return holder;
            }
        }
        throw new IllegalArgumentException("invalid viewtype");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            MenuProfileViewHolder mpvh = (MenuProfileViewHolder) holder;
            mpvh.setProfile(menuData.getProfile());
            return;
        }
        position--;
        if (menuData.getItems().size() > 0) {
            if (position < menuData.getItems().size()) {
                MenuItemViewHolder mivh = (MenuItemViewHolder) holder;
                mivh.setMenuitem(menuData.getItems().get(position));
                    return;
            }
            position -= menuData.getItems().size();
        }
        throw new IllegalArgumentException(("Invalid position"));
    }

    @Override
    public int getItemCount() {
        if(menuData == null) {
            return 0;
        }
        int count = 0;
        if(menuData.getProfile() != null) count++;
        if(menuData.getItems() != null) count += menuData.getItems().size();

        return count;
    }



    public interface OnAdapterItemClickLIstener {
        public void onAdapterItemClick(View view, Menuitem menuitem, int position);
    }

    OnAdapterItemClickLIstener listener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickLIstener listener) {
        this.listener = listener;
    }

    @Override
    public void onMenuItemClick(View view, Menuitem menuitem, int position) {
        if (listener != null) {
            listener.onAdapterItemClick(view, menuitem, position);
        }
    }
}

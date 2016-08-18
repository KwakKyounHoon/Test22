package com.didimdol.kwak.test.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.didimdol.kwak.test.R;
import com.didimdol.kwak.test.adapter.MenuAdapter;
import com.didimdol.kwak.test.data.MenuData;
import com.didimdol.kwak.test.data.Menuitem;
import com.didimdol.kwak.test.data.Profile;

/**
 * Created by Kwak on 2016-08-16.
 */
public class MenuFragment extends Fragment {

    private OnMenuSelectListener mListener;

    //    MenuAdapter mAdapter;
    RecyclerView rv_list;
    //    ExpandableListView rv_list;
    MenuAdapter mAdapter;

    MenuData menuData;


    public static final int MENU_SEARCH = 100;
    public static final int MENU_HOME = 101;
    public static final int MENU_MESSAGE = 102;
    public static final int MENU_TRIP = 103;
    public static final int MENU_WISH = 104;
    public static final int MENU_PROFILE = 105;
    public static final int MENU_SETTING = 106;
    public static final int MENU_HELP = 107;
    public static final int MENU_GIFT = 108;
    public static final int MENU_FEED = 109;



    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new MenuAdapter();


//
    }

    private void init() {
        menuData = new MenuData();
        Profile profile = new Profile();
        profile.setName("견훈");
        profile.setEmail("kkhstart@gmail.com");
        menuData.setProfile(profile);
        Menuitem menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.searchicon),"검색", MENU_SEARCH);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.homeicon),"홈", MENU_HOME);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.message),"메세지", MENU_MESSAGE);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.yahang),"여행", MENU_TRIP);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.wish),"위시리스트", MENU_WISH);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.profile),"프로필", MENU_PROFILE);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.setting),"환경설정", MENU_SETTING);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.help),"도움말", MENU_HELP);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.gift),"친구 초대하기",MENU_GIFT);
        menuData.getItems().add(menuitem);
        menuitem = new Menuitem(ContextCompat.getDrawable(getContext(),R.drawable.feed),"피드백 남기기",MENU_FEED);
        menuData.getItems().add(menuitem);
        mAdapter.addData(menuData);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
//        rv_list = (ExpandableListView)view.findViewById(R.id.list_menu);
        rv_list = (RecyclerView) view.findViewById(R.id.list_menu);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv_list.setLayoutManager(manager);
        rv_list.setAdapter(mAdapter);
        mAdapter.setOnAdapterItemClickListener(new MenuAdapter.OnAdapterItemClickLIstener() {
            @Override
            public void onAdapterItemClick(View view, Menuitem menuitem, int position) {
                mListener.onMenuSelected(menuitem.getMenuCode());
            }
        });
        init();
        return view;
    }

    public interface OnMenuSelectListener {
        // TODO: Update argument type and name
        void onMenuSelected(int menuId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuSelectListener) {
            mListener = (OnMenuSelectListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMenuSelectListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}

package com.didimdol.kwak.test;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.didimdol.kwak.test.adapter.MyAdapter;

public class ContentActivity extends AppCompatActivity {

    AppBarLayout appBar;
    RecyclerView listView;
    MyAdapter mAdapter;
    TabLayout tabs;
    Toolbar toolbar;
    int po;
    CollapsingToolbarLayout collapsingToolbar;
    ImageView imageview;
    boolean ok = false;
    Drawable icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView = (RecyclerView)findViewById(R.id.rv_list);
        mAdapter = new MyAdapter();
        listView.setAdapter(mAdapter);
        final LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listView.setLayoutManager(manager);
        imageview = (ImageView)findViewById(R.id.image_col);

        icon = ContextCompat.getDrawable(this,R.drawable.menuicon);
        icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        getSupportActionBar().setHomeAsUpIndicator(icon);


        appBar = (AppBarLayout)findViewById(R.id.appbar);

        listView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                Log.i("test3",dy+"");

                if(firstVisibleItem == 0 && dy <0){
                    imageview.setVisibility(View.VISIBLE);
                    toolbar.setBackgroundColor(Color.alpha(0));
                    icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                }
            }
        });

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {


                if(verticalOffset==-570){
                    imageview.setVisibility(View.GONE);
                    toolbar.setBackgroundColor(Color.alpha(255));
                    icon.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                }
            }
        });





    }

    @Override
    public void finish() {
        super.finish();
        icon.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
    }
}

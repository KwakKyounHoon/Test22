package com.didimdol.kwak.test;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.didimdol.kwak.test.adapter.CityListAdapter;
import com.didimdol.kwak.test.data.CityContent;
import com.didimdol.kwak.test.data.CityContents;

public class ContentActivity extends AppCompatActivity {

    AppBarLayout appBar;
    RecyclerView listView;
//    MyAdapter mAdapter;

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbar;
    ImageView imageview;
    boolean ok = false;
    Drawable icon;
    CityListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAdapter = new CityListAdapter(this);

        listView = (RecyclerView)findViewById(R.id.rv_list);
        listView.setAdapter(mAdapter);
        final LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listView.setLayoutManager(manager);

        DividerItemDecoration decoration = new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
        listView.addItemDecoration(decoration);
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
                LinearLayoutManager lm= (LinearLayoutManager) recyclerView.getLayoutManager();
//                int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
//                int visibleItemCount = recyclerView.getChildCount();
//                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
//                Log.i("test3",firstVisibleItem+"");
//                Log.i("test2",visibleItemCount+"");
//                Log.i("test1",totalItemCount+"");

//                if(firstVisibleItem == 0 && dy <0){
                if(lm.findViewByPosition(lm.findFirstVisibleItemPosition()).getTop()==0 && lm.findFirstVisibleItemPosition()==0){
                    imageview.setVisibility(View.VISIBLE);
                    icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                }
            }
        });

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(verticalOffset==-570){
                    imageview.setVisibility(View.GONE);
                    icon.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                }
            }
        });

        init();
    }

    private void init() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("cityname");
        int id = intent.getIntExtra("imageid",0);

        imageview.setImageDrawable(ContextCompat.getDrawable(this,id));


        CityContents cityContents = new CityContents();
        cityContents.setName(name);

        CityContent cityContent = new CityContent();
        cityContent.setName("Lovely Bright Double Rooms");
        cityContent.setCount("29");
        cityContent.setHouse("집 전체");
        cityContent.setCityImage(ContextCompat.getDrawable(this,R.drawable.house));
        cityContents.getCityContent().add(cityContent);

        cityContent = new CityContent();
        cityContent.setName("Lovely Bright Double Rooms");
        cityContent.setCount("29");
        cityContent.setHouse("집 전체");
        cityContent.setCityImage(ContextCompat.getDrawable(this,R.drawable.house));
        cityContents.getCityContent().add(cityContent);

        cityContent = new CityContent();
        cityContent.setName("Lovely Bright Double Rooms");
        cityContent.setCount("29");
        cityContent.setHouse("집 전체");
        cityContent.setCityImage(ContextCompat.getDrawable(this,R.drawable.house));
        cityContents.getCityContent().add(cityContent);

        cityContent = new CityContent();
        cityContent.setName("Lovely Bright Double Rooms");
        cityContent.setCount("29");
        cityContent.setHouse("집 전체");
        cityContent.setCityImage(ContextCompat.getDrawable(this,R.drawable.house));
        cityContents.getCityContent().add(cityContent);

        mAdapter.addCityContents(cityContents);
    }

    @Override
    public void finish() {
        super.finish();
        icon.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
    }
}

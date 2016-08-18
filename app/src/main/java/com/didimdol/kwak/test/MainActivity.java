package com.didimdol.kwak.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.didimdol.kwak.test.fragment.MainFragment;
import com.didimdol.kwak.test.fragment.MenuFragment;
import com.didimdol.kwak.test.fragment.MessageFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnMenuSelectListener
,MainFragment.OnMainFragmentSelectListener{



    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menuicon);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_click);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void init() {

    }

    private void changeFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f)
                .commit();
    }

    @Override
    public void onMenuSelected(int menuId) {
        switch (menuId) {
            case MenuFragment.MENU_SEARCH : {
                changeFragment(MessageFragment.newInstance("Main"));
                break;
            }
            case MenuFragment.MENU_HOME: {
                changeFragment(MainFragment.newInstance());
                break;
            }
            case MenuFragment.MENU_MESSAGE: {
                changeFragment(MessageFragment.newInstance("Logout"));
                break;
            }
            case MenuFragment.MENU_TRIP: {
                changeFragment(MessageFragment.newInstance("Keyword search"));
                break;
            }
            case MenuFragment.MENU_WISH: {
                changeFragment(MessageFragment.newInstance("date search"));
                break;
            }
            case MenuFragment.MENU_PROFILE: {
                changeFragment(MessageFragment.newInstance("push setting"));
                break;
            }
            case MenuFragment.MENU_SETTING: {
                changeFragment(MessageFragment.newInstance("about"));
                break;
            }
            case MenuFragment.MENU_HELP: {
                changeFragment(MessageFragment.newInstance("about"));
                break;
            }
            case MenuFragment.MENU_GIFT: {
                changeFragment(MessageFragment.newInstance("about"));
                break;
            }
            case MenuFragment.MENU_FEED: {
                changeFragment(MessageFragment.newInstance("about"));
                break;
            }
            default:
                return;
        }
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onMainFragmentSelectListner(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit();
    }

//    @Override
//    public void onFragmentItemClick(View view, Menuitem menuitem, int position) {
//        switch (menuitem.getMenuCode()) {
//            case MenuFragment.MENU_SEARCH : {
//                Toast.makeText(MainActivity.this, "menuitem : " + menuitem.getIconName(), Toast.LENGTH_SHORT).show();
//                changeFragment(MessageFragment.newInstance("Main"));
//                break;
//            }
//            case MenuFragment.MENU_HOME: {
//                Toast.makeText(MainActivity.this, "menuitem : " + menuitem.getIconName(), Toast.LENGTH_SHORT).show();
//                changeFragment(MessageFragment.newInstance("Profile"));
//                break;
//            }
//            case MenuFragment.MENU_MESSAGE: {
//                changeFragment(MessageFragment.newInstance("Logout"));
//                break;
//            }
//            case MenuFragment.MENU_TRIP: {
//                changeFragment(MessageFragment.newInstance("Keyword search"));
//                break;
//            }
//            case MenuFragment.MENU_WISH: {
//                changeFragment(MessageFragment.newInstance("date search"));
//                break;
//            }
//            case MenuFragment.MENU_PROFILE: {
//                changeFragment(MessageFragment.newInstance("push setting"));
//                break;
//            }
//            case MenuFragment.MENU_SETTING: {
//                changeFragment(MessageFragment.newInstance("about"));
//                break;
//            }
//            case MenuFragment.MENU_HELP: {
//                changeFragment(MessageFragment.newInstance("about"));
//                break;
//            }
//            case MenuFragment.MENU_GIFT: {
//                changeFragment(MessageFragment.newInstance("about"));
//                break;
//            }
//            case MenuFragment.MENU_FEED: {
//                changeFragment(MessageFragment.newInstance("about"));
//                break;
//            }
//            default:
//                return;
//        }
//        drawer.closeDrawer(GravityCompat.START);
//    }
}

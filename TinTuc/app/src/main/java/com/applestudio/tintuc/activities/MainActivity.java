package com.applestudio.tintuc.activities;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.applestudio.tintuc.R;
import com.applestudio.tintuc.adapters.ListMenuAdapter;
import com.applestudio.tintuc.adapters.ListNewsAdapter;
import com.applestudio.tintuc.models.MenuObject;
import com.applestudio.tintuc.models.NewsObject;
import com.applestudio.tintuc.utils.Constant;
import com.applestudio.tintuc.utils.GridSpacingItemDecoration;
import com.applestudio.tintuc.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private DrawerLayout drawer;
    private View mainContent;
    private ImageView buttonMenu;
    private RecyclerView listNewsView;
    private ListNewsAdapter newsAdapter;
    private ArrayList<NewsObject> listNews;

    private ListView listMenuView;
    private ListMenuAdapter menuAdapter;
    private ArrayList<MenuObject> listMenu;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mainContent = findViewById(R.id.main_content);
        buttonMenu = (ImageView) findViewById(R.id.button_menu);
        listNewsView = (RecyclerView) findViewById(R.id.list_news);
        listMenuView = (ListView) findViewById(R.id.list_menu);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        createDrawerLayout();

        listNews = new ArrayList<>();

        newsAdapter = new ListNewsAdapter(this, listNews, new ListNewsAdapter.PositionClickListener() {
            @Override
            public void itemClicked(int position) {
                startActivity(DetailActivity.class);
            }
        });
        newsAdapter.setHasStableIds(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 1 || position == 2 || position == 3) {
                    return 1;
                }
                return 2;
            }
        });

        listNewsView.setLayoutManager(gridLayoutManager);
        listNewsView.addItemDecoration(new SimpleDividerItemDecoration(this));
        listNewsView.addItemDecoration(new GridSpacingItemDecoration(2, Constant.convertDpIntoPixels(10, this), true));
        listNewsView.setAdapter(newsAdapter);

        Constant.increaseHitArea(buttonMenu);

        buttonMenu.setOnClickListener(this);
    }

    public void createDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainContent.setTranslationX(slideOffset * drawerView.getWidth());
                drawer.bringChildToFront(drawerView);
                drawer.requestLayout();
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // Create Navigation Drawer layout left
        listMenu = new ArrayList<>();
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));
        listMenu.add(new MenuObject(R.mipmap.ic_launcher, getResources().getString(R.string.thoi_su)));

        menuAdapter = new ListMenuAdapter(this, listMenu);
        listMenuView.setAdapter(menuAdapter);
        listMenuView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 7:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 8:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 9:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 10:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 11:
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_menu:
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
                break;
        }
    }
}

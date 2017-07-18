package com.applestudio.tintuc.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.applestudio.tintuc.R;
import com.applestudio.tintuc.adapters.ListMenuAdapter;
import com.applestudio.tintuc.adapters.ListNewsAdapter;
import com.applestudio.tintuc.models.MenuObject;
import com.applestudio.tintuc.models.NewsObject;
import com.applestudio.tintuc.utils.Constant;
import com.applestudio.tintuc.utils.SimpleDividerItemDecoration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
                startActivity(NewsDetailActivity.class);
            }
        });
        newsAdapter.setHasStableIds(true);

        listNewsView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listNewsView.addItemDecoration(new SimpleDividerItemDecoration(this));
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
                /*if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }*/
                openImageIntent();
                break;
        }
    }

    private void openImageIntent() {

        // Determine Uri of camera image to save.
        /*final File root = new File(Environment.getExternalStorageDirectory() + File.separator + "MyDir" + File.separator);
        root.mkdirs();
        final String fname = Utils.getUniqueImageFilename();
        final File sdImageMainDirectory = new File(root, fname);
        outputFileUri = Uri.fromFile(sdImageMainDirectory);*/

        // Camera.
        final List<Intent> cameraIntents = new ArrayList<Intent>();
        final Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        final PackageManager packageManager = getPackageManager();
        final List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for(ResolveInfo res : listCam) {
            final String packageName = res.activityInfo.packageName;
            final Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(packageName, res.activityInfo.name));
            intent.setPackage(packageName);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, "wdgweg");
            cameraIntents.add(intent);
        }

        // Filesystem.
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

        // Chooser of filesystem options.
        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Select Source");

        // Add the camera options.
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, cameraIntents.toArray(new Parcelable[cameraIntents.size()]));

        startActivityForResult(chooserIntent, 1);
    }
}

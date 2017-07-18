package com.applestudio.tintuc.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.applestudio.tintuc.R;
import com.applestudio.tintuc.activities.ImageActivity;

/**
 * Created by lequy on 7/18/2017.
 */

public class WallpaperFragment extends BaseFragment implements View.OnClickListener {
    private ImageView imgSample;

    public static WallpaperFragment newInstance() {
        Bundle args = new Bundle();

        WallpaperFragment fragment = new WallpaperFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_wallpaper;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState, View rootView) {
        imgSample = (ImageView) rootView.findViewById(R.id.img_sample);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        imgSample.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_sample:
                startActivity(ImageActivity.class);
                break;
        }
    }
}

package com.applestudio.tintuc.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.applestudio.tintuc.R;
import com.applestudio.tintuc.fragments.NewsFragment;
import com.applestudio.tintuc.utils.Constant;

/**
 * Created by lequy on 7/10/2017.
 */

public class DetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView buttonBack;
    private ImageView buttonPrevious;
    private ImageView buttonNext;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        buttonBack = (ImageView) findViewById(R.id.button_back);
        buttonPrevious = (ImageView) findViewById(R.id.button_previous);
        buttonNext = (ImageView) findViewById(R.id.button_next);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        changeFragmentNoAnim(NewsFragment.newInstance(), R.id.news_content);

        Constant.increaseHitArea(buttonBack);
        buttonBack.setOnClickListener(this);
        buttonPrevious.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                finish();
                break;
            case R.id.button_previous:
                changeFragment2(NewsFragment.newInstance(), R.id.news_content);
                break;
            case R.id.button_next:
                changeFragment1(NewsFragment.newInstance(), R.id.news_content);
                break;
        }
    }

    private void changeFragmentNoAnim(Fragment fragment, int layoutId){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.anim.enter_anim_ltr, R.anim.exit_anim_ltr, R.anim.enter_anim_rtl, R.anim.exit_anim_rtl);
        ft.replace(layoutId, fragment);
        //ft.addToBackStack(null);
        ft.commit();
    }

    private void changeFragment1(Fragment fragment, int layoutId){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.enter_anim_ltr, R.anim.exit_anim_ltr, R.anim.enter_anim_rtl, R.anim.exit_anim_rtl);
        ft.replace(layoutId, fragment);
        //ft.addToBackStack(null);
        ft.commit();
    }

    private void changeFragment2(Fragment fragment, int layoutId){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.enter_anim_rtl, R.anim.exit_anim_rtl, R.anim.enter_anim_ltr, R.anim.exit_anim_ltr);
        ft.replace(layoutId, fragment);
        //ft.addToBackStack(null);
        ft.commit();
    }
}

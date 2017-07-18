package com.applestudio.tintuc.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.applestudio.tintuc.R;
import com.applestudio.tintuc.adapters.ListRelatedAdapter;
import com.applestudio.tintuc.models.NewsObject;
import com.applestudio.tintuc.utils.Constant;
import com.applestudio.tintuc.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by lequy on 7/10/2017.
 */

public class NewsDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView buttonBack;
    private RecyclerView listRelatedNewsView;
    private ListRelatedAdapter relatedAdapter;
    private ArrayList<NewsObject> listRelatedNews;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        buttonBack = (ImageView) findViewById(R.id.button_back);
        listRelatedNewsView = (RecyclerView) findViewById(R.id.list_related_news);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        listRelatedNews = new ArrayList<>();

        relatedAdapter = new ListRelatedAdapter(this, listRelatedNews, new ListRelatedAdapter.PositionClickListener() {
            @Override
            public void itemClicked(int position) {
                startActivity(NewsDetailActivity.class);
            }
        });
        relatedAdapter.setHasStableIds(true);

        listRelatedNewsView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listRelatedNewsView.addItemDecoration(new SimpleDividerItemDecoration(this));
        listRelatedNewsView.setAdapter(relatedAdapter);

        Constant.increaseHitArea(buttonBack);

        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                finish();
                break;
        }
    }
}

package com.applestudio.tintuc.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.applestudio.tintuc.R;
import com.applestudio.tintuc.activities.DetailActivity;
import com.applestudio.tintuc.adapters.ListRelatedAdapter;
import com.applestudio.tintuc.models.NewsObject;
import com.applestudio.tintuc.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by lequy on 7/18/2017.
 */

public class NewsFragment extends BaseFragment {
    private RecyclerView listRelatedNewsView;
    private ListRelatedAdapter relatedAdapter;
    private ArrayList<NewsObject> listRelatedNews;

    public static NewsFragment newInstance() {
        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState, View rootView) {
        listRelatedNewsView = (RecyclerView) rootView.findViewById(R.id.list_related_news);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        listRelatedNews = new ArrayList<>();

        relatedAdapter = new ListRelatedAdapter(getActivity(), listRelatedNews, new ListRelatedAdapter.PositionClickListener() {
            @Override
            public void itemClicked(int position) {
                startActivity(DetailActivity.class);
            }
        });
        relatedAdapter.setHasStableIds(true);

        listRelatedNewsView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        listRelatedNewsView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        listRelatedNewsView.setAdapter(relatedAdapter);
    }
}

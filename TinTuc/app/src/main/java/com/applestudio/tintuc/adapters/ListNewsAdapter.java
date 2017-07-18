package com.applestudio.tintuc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.applestudio.tintuc.R;
import com.applestudio.tintuc.models.NewsObject;

import java.util.ArrayList;

/**
 * Created by lequy on 7/10/2017.
 */

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsAdapter.RecyclerViewHolder> {
    private Context context;
    private ArrayList<NewsObject> listNews;

    private PositionClickListener listener;
    private int selectedPos = 0;

    public ListNewsAdapter(Context context, ArrayList<NewsObject> listNews, PositionClickListener listener) {
        this.context = context;
        this.listNews = listNews;
        this.listener = listener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_news, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.itemView.setSelected(selectedPos == position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface PositionClickListener {
        void itemClicked(int position);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.itemClicked(getLayoutPosition());
            notifyItemChanged(selectedPos);
            selectedPos = getLayoutPosition();
            notifyItemChanged(selectedPos);
        }
    }
}

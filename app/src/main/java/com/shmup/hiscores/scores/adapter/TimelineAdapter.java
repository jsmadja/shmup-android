package com.shmup.hiscores.scores.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.TimelineItem;

import java.util.List;

public class TimelineAdapter extends BaseAdapter {

    private final Context context;
    private List<TimelineItem> items;

    public TimelineAdapter(List<TimelineItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public TimelineItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemview_timeline, parent, false);
        TextView playerTextView = (TextView) view.findViewById(R.id.playerTextView);
        TextView scoreTextView = (TextView) view.findViewById(R.id.scoreTextView);

        TimelineItem item = getItem(position);
        playerTextView.setText(item.getPlayer().getName());
        scoreTextView.setText(item.getScore().getValue().toString());

        return view;
    }
}

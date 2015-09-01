package com.shmup.hiscores.scores.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.TimelineItem;
import com.shmup.hiscores.scores.view.TimelineItemView;

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
        TimelineItemView timelineItemView;
        if (convertView == null) {
            timelineItemView = (TimelineItemView) LayoutInflater.from(context).inflate(R.layout.itemview_timeline, parent, false);
        } else {
            timelineItemView = (TimelineItemView) convertView;
        }
        timelineItemView.bindView(getItem(position));
        return timelineItemView;
    }

}

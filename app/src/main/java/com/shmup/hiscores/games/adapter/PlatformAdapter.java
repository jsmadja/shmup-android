package com.shmup.hiscores.games.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.Platform;
import com.shmup.hiscores.scores.view.PlatformItemView;

import java.util.ArrayList;
import java.util.List;

public class PlatformAdapter extends BaseAdapter {

    private List<Platform> platforms = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public PlatformAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms.clear();
        this.platforms.addAll(platforms);
        notifyDataSetChanged();
    }

    public Platform getPlatformAt(int position) {
        return platforms.get(position);
    }

    @Override
    public int getCount() {
        return platforms.size();
    }

    @Override
    public Platform getItem(int position) {
        return platforms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlatformItemView platformItemView;
        if (convertView == null) {
            platformItemView = (PlatformItemView) this.layoutInflater.inflate(R.layout.itemview_platform, parent, false);
        } else {
            platformItemView = (PlatformItemView) convertView;
        }
        platformItemView.bindView(getItem(position));
        return platformItemView;    }


}

package com.shmup.hiscores.games.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.model.Option;
import com.shmup.hiscores.games.view.OptionItemView;

import java.util.ArrayList;
import java.util.List;

public class OptionAdapter<T extends Option> extends BaseAdapter {

    private List<T> options = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private int layout;

    public OptionAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.layout = R.layout.itemview_option;
    }

    public void setOptions(List<T> options) {
        this.options.clear();
        this.options.addAll(options);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return options.size();
    }

    @Override
    public T getItem(int position) {
        return options.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OptionItemView itemView;
        if (convertView == null) {
            itemView = (OptionItemView) this.layoutInflater.inflate(layout, parent, false);
        } else {
            itemView = (OptionItemView) convertView;
        }
        itemView.bindView(getItem(position));
        return itemView;
    }

}

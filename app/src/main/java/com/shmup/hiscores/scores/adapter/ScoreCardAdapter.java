package com.shmup.hiscores.scores.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.ScoreCardItem;
import com.shmup.hiscores.scores.view.ScoreCardItemView;

import java.util.ArrayList;
import java.util.List;

public class ScoreCardAdapter extends BaseAdapter {

    private List<ScoreCardItem> items = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public ScoreCardAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setItems(List<ScoreCardItem> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ScoreCardItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScoreCardItemView scoreCardItemView;
        if (convertView == null) {
            scoreCardItemView = (ScoreCardItemView) this.layoutInflater.inflate(R.layout.itemview_score_card, parent, false);
        } else {
            scoreCardItemView = (ScoreCardItemView) convertView;
        }
        scoreCardItemView.bindView(getItem(position));
        return scoreCardItemView;
    }

}

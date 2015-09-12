package com.shmup.hiscores.games.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.view.RankingScoreItemView;
import com.shmup.hiscores.scores.model.ScoreCardItem;

import java.util.List;

public class RankingScoreAdapter extends RecyclerView.Adapter<RankingScoreAdapter.ViewHolder> {

    private List<ScoreCardItem> scores;

    public RankingScoreAdapter(List<ScoreCardItem> scores) {
        this.scores = scores;
    }

    @Override
    public RankingScoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RankingScoreItemView v = (RankingScoreItemView) LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_ranking_score, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(RankingScoreAdapter.ViewHolder holder, int position) {
        holder.rankingScoreItemView.bindView(scores.get(position));
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public RankingScoreItemView rankingScoreItemView;

        public ViewHolder(RankingScoreItemView rankingScoreItemView) {
            super(rankingScoreItemView);
            this.rankingScoreItemView = rankingScoreItemView;
        }
    }
}

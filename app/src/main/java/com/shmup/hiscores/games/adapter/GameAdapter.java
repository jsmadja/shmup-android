package com.shmup.hiscores.games.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.model.Game;
import com.shmup.hiscores.games.view.GameItemView;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<Game> games = new ArrayList<>();

    public void setGames(List<Game> games) {
        this.games.clear();
        this.games.addAll(games);
        notifyDataSetChanged();
    }

    public Game getGameAt(int position) {
        return games.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public GameItemView gameItemView;

        public ViewHolder(GameItemView gameItemView) {
            super(gameItemView);
            this.gameItemView = gameItemView;
        }
    }

    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GameItemView v = (GameItemView) LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_game, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.gameItemView.bindView(games.get(position));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

}

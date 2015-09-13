package com.shmup.hiscores.games.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.shmup.hiscores.games.model.Game;
import com.shmup.hiscores.games.model.Ranking;
import com.shmup.hiscores.scores.model.ScoreCardItem;
import com.shmup.hiscores.ui.score.read.RankingFragment;
import com.shmup.hiscores.ui.score.read.ScoreFragment;

import java.util.List;

public class ScoreAdapter extends FragmentStatePagerAdapter {

    private ScoreCardItem score;
    private Game game;

    public ScoreAdapter(ScoreCardItem score, FragmentManager fm) {
        super(fm);
        this.score = score;
        this.game = score.getGame();
    }

    public void setGame(Game game) {
        this.game = game;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return getRankings().size() + 1;
    }

    private List<Ranking> getRankings() {
        return this.game.getRankings();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return ScoreFragment.newInstance(score);
        }
        return RankingFragment.newInstance(getRankings().get(position - 1));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return score.getPlayer().getName();
        }
        Ranking ranking = getRankings().get(position - 1);
        return ranking.getName();
    }
}

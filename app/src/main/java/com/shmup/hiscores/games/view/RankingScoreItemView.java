package com.shmup.hiscores.games.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.ScoreCardItem;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RankingScoreItemView extends LinearLayout {

    @Bind(R.id.rankTextView) TextView rankTextView;
    @Bind(R.id.playerTextView) TextView playerTextView;
    @Bind(R.id.scoreTextView) TextView scoreTextView;
    @Bind(R.id.stageTextView) TextView stageTextView;
    @Bind(R.id.oneccTextView) TextView oneccTextView;


    public RankingScoreItemView(Context context) {
        this(context, null);
    }

    public RankingScoreItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindView(ScoreCardItem score) {
        rankTextView.setText(score.getRank());
        playerTextView.setText(score.getPlayer().getName());
        scoreTextView.setText(score.getValue());
        stageTextView.setText(score.getStageName());
        oneccTextView.setVisibility(score.isOnecc() ? VISIBLE : GONE);
        oneccTextView.setText(R.string.oneCC);
    }

}

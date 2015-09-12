package com.shmup.hiscores.scores.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.ScoreCardItem;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.lang.String.format;

public class ScoreCardItemView extends LinearLayout {

    @Bind(R.id.playerTextView) TextView playerTextView;
    @Bind(R.id.scoreTextView) TextView scoreTextView;
    @Bind(R.id.dateTextView) TextView dateTextView;
    @Bind(R.id.coverImageView) ImageView coverImageView;
    @Bind(R.id.platformTextView) TextView platformTextView;
    @Bind(R.id.difficultyTextView) TextView difficultyTextView;
    @Bind(R.id.modeTextView) TextView modeTextView;
    @Bind(R.id.oneccTextView) TextView oneccTextView;
    @Bind(R.id.gameTextView) TextView gameTextView;
    @Bind(R.id.photoTextView) TextView photoTextView;
    @Bind(R.id.replayTextView) TextView replayTextView;
    @Bind(R.id.rankTextView) TextView rankTextView;
    @Bind(R.id.stageTextView) TextView stageTextView;

    public ScoreCardItemView(Context context) {
        this(context, null);
    }

    public ScoreCardItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindView(ScoreCardItem scoreCardItem) {
        if (scoreCardItem.getPlayer() != null) {
            playerTextView.setText(scoreCardItem.getPlayer().getName());
        }
        if (scoreCardItem.getValue() != null) {
            scoreTextView.setText(format("%s %s", scoreCardItem.getValue(), getResources().getString(R.string.scoreSuffix)));
        }
        if (scoreCardItem.getDate() != null) {
            dateTextView.setText(scoreCardItem.getDate());
        }
        if (scoreCardItem.getPlatform() == null) {
            platformTextView.setVisibility(GONE);
        } else {
            platformTextView.setText(scoreCardItem.getPlatform().getName());
            platformTextView.setVisibility(VISIBLE);
        }
        if (scoreCardItem.getGame() != null) {
            gameTextView.setText(scoreCardItem.getGame().getTitle());
        }
        if (scoreCardItem.getRank() != null) {
            rankTextView.setText(scoreCardItem.getRank());
        }
        if (scoreCardItem.getDifficulty() == null) {
            difficultyTextView.setVisibility(GONE);
        } else {
            difficultyTextView.setVisibility(VISIBLE);
            difficultyTextView.setText(scoreCardItem.getDifficulty().getName());
        }
        if (scoreCardItem.getMode() == null) {
            modeTextView.setVisibility(GONE);
        } else {
            modeTextView.setVisibility(VISIBLE);
            modeTextView.setText(scoreCardItem.getMode().getName());
        }
        if (scoreCardItem.isOnecc()) {
            oneccTextView.setVisibility(VISIBLE);
            oneccTextView.setText(R.string.oneCC);
        } else {
            oneccTextView.setVisibility(GONE);
        }
        if (scoreCardItem.hasStage()) {
            stageTextView.setVisibility(VISIBLE);
            stageTextView.setText(format("%s %s", getResources().getString(R.string.stagePrefix), scoreCardItem.getStageName()));
        } else {
            stageTextView.setVisibility(GONE);
        }
        photoTextView.setVisibility(scoreCardItem.hasPhoto() ? VISIBLE : GONE);
        replayTextView.setVisibility(scoreCardItem.hasReplay() ? VISIBLE : GONE);
        Picasso.with(getContext()).load(scoreCardItem.getCover()).into(coverImageView);
    }

}

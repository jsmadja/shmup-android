package com.shmup.hiscores.scores.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.ScoreCardItem;
import com.squareup.picasso.Picasso;

import static java.lang.String.format;

/**
 * Mettre ButterKnife
 */
public class ScoreCardItemView extends LinearLayout {

    private TextView playerTextView;
    private TextView scoreTextView;
    private TextView dateTextView;
    private ImageView coverImageView;
    private TextView platformTextView;
    private TextView difficultyTextView;
    private TextView modeTextView;
    private TextView oneccTextView;
    private TextView gameTextView;
    private TextView photoTextView;
    private TextView replayTextView;
    private TextView rankTextView;
    private TextView stageTextView;

    public ScoreCardItemView(Context context) {
        this(context, null);
    }

    public ScoreCardItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        playerTextView = (TextView) findViewById(R.id.playerTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        coverImageView = (ImageView) findViewById(R.id.coverImageView);
        platformTextView = (TextView) findViewById(R.id.platformTextView);
        difficultyTextView = (TextView) findViewById(R.id.difficultyTextView);
        modeTextView = (TextView) findViewById(R.id.modeTextView);
        oneccTextView = (TextView) findViewById(R.id.oneccTextView);
        gameTextView = (TextView) findViewById(R.id.gameTextView);
        photoTextView = (TextView) findViewById(R.id.photoTextView);
        replayTextView = (TextView) findViewById(R.id.replayTextView);
        rankTextView = (TextView) findViewById(R.id.rankTextView);
        stageTextView = (TextView) findViewById(R.id.stageTextView);
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

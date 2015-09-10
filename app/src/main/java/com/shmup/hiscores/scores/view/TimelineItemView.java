package com.shmup.hiscores.scores.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.TimelineItem;
import com.squareup.picasso.Picasso;

import static java.lang.String.format;

/**
 * Mettre ButterKnife
 */
public class TimelineItemView extends LinearLayout {

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

    public TimelineItemView(Context context) {
        this(context, null);
    }

    public TimelineItemView(Context context, AttributeSet attrs) {
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

    public void bindView(TimelineItem timelineItem) {
        playerTextView.setText(timelineItem.getPlayer().getName());
        scoreTextView.setText(format("%s %s", timelineItem.getValue(), getResources().getString(R.string.scoreSuffix)));
        dateTextView.setText(timelineItem.getDate());
        platformTextView.setText(timelineItem.getPlatform().getName());
        gameTextView.setText(timelineItem.getGame().getTitle());
        rankTextView.setText(timelineItem.getRank());
        if (timelineItem.getDifficulty() == null) {
            difficultyTextView.setVisibility(GONE);
        } else {
            difficultyTextView.setVisibility(VISIBLE);
            difficultyTextView.setText(timelineItem.getDifficulty().getName());
        }
        if (timelineItem.getMode() == null) {
            modeTextView.setVisibility(GONE);
        } else {
            modeTextView.setVisibility(VISIBLE);
            modeTextView.setText(timelineItem.getMode().getName());
        }
        if (timelineItem.isOnecc()) {
            oneccTextView.setVisibility(VISIBLE);
            oneccTextView.setText(R.string.oneCC);
        } else {
            oneccTextView.setVisibility(GONE);
        }
        if (timelineItem.hasStage()) {
            stageTextView.setVisibility(VISIBLE);
            stageTextView.setText(timelineItem.getStageName());
        } else {
            stageTextView.setVisibility(GONE);
        }
        photoTextView.setVisibility(timelineItem.hasPhoto() ? VISIBLE : GONE);
        replayTextView.setVisibility(timelineItem.hasReplay() ? VISIBLE : GONE);
        Picasso.with(getContext()).load(timelineItem.getCover()).into(coverImageView);
    }

}

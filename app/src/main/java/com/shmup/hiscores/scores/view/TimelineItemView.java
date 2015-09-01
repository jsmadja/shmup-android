package com.shmup.hiscores.scores.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.TimelineItem;

public class TimelineItemView extends LinearLayout {

    private TextView playerTextView;
    private TextView scoreTextView;

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
    }

    public void bindView(TimelineItem timelineItem) {
        this.playerTextView.setText(timelineItem.getPlayer().getName());
        this.scoreTextView.setText(timelineItem.getScore().getValue().toString());
    }
}

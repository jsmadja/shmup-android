package com.shmup.hiscores.scores.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.Platform;

/**
 * Mettre ButterKnife
 */
public class PlatformItemView extends LinearLayout {

    private TextView platformTextView;

    public PlatformItemView(Context context) {
        this(context, null);
    }

    public PlatformItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        platformTextView = (TextView) findViewById(R.id.platformTextView);
    }

    public void bindView(Platform platform) {
        platformTextView.setText(platform.getName());
    }

}

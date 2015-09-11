package com.shmup.hiscores.games.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.model.Option;

/**
 * Mettre ButterKnife
 */
public class PlatformItemView extends LinearLayout implements BindableItemView {

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

    @Override
    public void bindView(Option option) {
        platformTextView.setText(option.getName());
    }
}

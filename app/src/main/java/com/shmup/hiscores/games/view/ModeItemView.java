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
public class ModeItemView extends LinearLayout implements BindableItemView {

    private TextView modeTextView;

    public ModeItemView(Context context) {
        this(context, null);
    }

    public ModeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        modeTextView = (TextView) findViewById(R.id.modeTextView);
    }

    @Override
    public void bindView(Option option) {
        modeTextView.setText(option.getName());
    }
}

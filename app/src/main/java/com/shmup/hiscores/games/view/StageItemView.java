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
public class StageItemView extends LinearLayout implements BindableItemView {

    private TextView stageTextView;

    public StageItemView(Context context) {
        this(context, null);
    }

    public StageItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        stageTextView = (TextView) findViewById(R.id.stageTextView);
    }

    @Override
    public void bindView(Option option) {
        stageTextView.setText(option.getName());
    }
}

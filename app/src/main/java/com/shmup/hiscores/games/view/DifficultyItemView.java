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
public class DifficultyItemView extends LinearLayout implements BindableItemView {

    private TextView difficultyTextView;

    public DifficultyItemView(Context context) {
        this(context, null);
    }

    public DifficultyItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        difficultyTextView = (TextView) findViewById(R.id.difficultyTextView);
    }

    @Override
    public void bindView(Option option) {
        difficultyTextView.setText(option.getName());
    }
}

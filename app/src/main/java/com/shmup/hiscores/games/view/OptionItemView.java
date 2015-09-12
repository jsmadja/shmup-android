package com.shmup.hiscores.games.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.model.Option;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OptionItemView extends LinearLayout {

    @Bind(R.id.optionTextView) TextView optionTextView;

    public OptionItemView(Context context) {
        this(context, null);
    }

    public OptionItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindView(Option option) {
        optionTextView.setText(option.getName());
    }
}

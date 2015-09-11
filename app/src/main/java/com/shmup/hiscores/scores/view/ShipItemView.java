package com.shmup.hiscores.scores.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.Option;

/**
 * Mettre ButterKnife
 */
public class ShipItemView extends LinearLayout implements BindableItemView {

    private TextView shipTextView;

    public ShipItemView(Context context) {
        this(context, null);
    }

    public ShipItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        shipTextView = (TextView) findViewById(R.id.shipTextView);
    }

    @Override
    public void bindView(Option option) {
        shipTextView.setText(option.getName());
    }
}

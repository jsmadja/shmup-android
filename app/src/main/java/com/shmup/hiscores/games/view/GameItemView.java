package com.shmup.hiscores.games.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.model.Game;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameItemView extends LinearLayout {

    @Bind(R.id.coverImageView) ImageView coverImageView;
    @Bind(R.id.gameTextView) TextView gameTextView;

    public GameItemView(Context context) {
        this(context, null);
    }

    public GameItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindView(Game game) {
        gameTextView.setText(game.getTitle());
        Picasso.with(getContext()).load(game.getCover()).into(coverImageView);
    }

}

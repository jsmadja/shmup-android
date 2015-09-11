package com.shmup.hiscores.games.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.model.Game;
import com.squareup.picasso.Picasso;

/**
 * Mettre ButterKnife
 */
public class GameItemView extends LinearLayout {

    private ImageView coverImageView;
    private TextView gameTextView;

    public GameItemView(Context context) {
        this(context, null);
    }

    public GameItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        coverImageView = (ImageView) findViewById(R.id.coverImageView);
        gameTextView = (TextView) findViewById(R.id.gameTextView);
    }

    public void bindView(Game game) {
        gameTextView.setText(game.getTitle());
        Picasso.with(getContext()).load(game.getCover()).into(coverImageView);
    }

}

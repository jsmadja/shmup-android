package com.shmup.hiscores.scores.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.TimelineItem;

import java.io.InputStream;

public class TimelineItemView extends LinearLayout {

    private TextView playerTextView;
    private TextView scoreTextView;
    private TextView dateTextView;
    private ImageView coverImageView;
    private TextView platformTextView;
    private TextView difficultyTextView;
    private TextView modeTextView;
    private TextView oneccTextView;
    private TextView gameTextView;

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
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        coverImageView = (ImageView) findViewById(R.id.coverImageView);
        platformTextView = (TextView) findViewById(R.id.platformTextView);
        difficultyTextView = (TextView) findViewById(R.id.difficultyTextView);
        modeTextView = (TextView) findViewById(R.id.modeTextView);
        oneccTextView = (TextView) findViewById(R.id.oneccTextView);
        gameTextView = (TextView) findViewById(R.id.gameTextView);
    }

    public void bindView(TimelineItem timelineItem) {
        playerTextView.setText(timelineItem.getPlayer().getName());
        scoreTextView.setText(timelineItem.getValue()+" pts");
        dateTextView.setText(timelineItem.getDate());
        platformTextView.setText(timelineItem.getPlatform().getName());
        gameTextView.setText(timelineItem.getGame().getTitle());
        if (timelineItem.getDifficulty() == null) {
            difficultyTextView.setVisibility(GONE);
        } else {
            difficultyTextView.setVisibility(VISIBLE);
            difficultyTextView.setText(timelineItem.getDifficulty().getName());
        }
        if (timelineItem.getMode() == null) {
            modeTextView.setVisibility(GONE);
        } else {
            modeTextView.setVisibility(VISIBLE);
            modeTextView.setText(timelineItem.getMode().getName());
        }
        if (timelineItem.isOnecc()) {
            oneccTextView.setVisibility(VISIBLE);
            oneccTextView.setText("1CC");
        } else {
            oneccTextView.setVisibility(GONE);
        }
        new DownloadImageTask(coverImageView).execute(timelineItem.getGame().getCover());
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

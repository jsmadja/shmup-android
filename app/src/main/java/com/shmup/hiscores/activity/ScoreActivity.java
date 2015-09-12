package com.shmup.hiscores.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.shmup.hiscores.HiscoresApplication;
import com.shmup.hiscores.R;
import com.shmup.hiscores.games.adapter.ScoreAdapter;
import com.shmup.hiscores.games.model.Game;
import com.shmup.hiscores.scores.model.ScoreCardItem;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        final ScoreCardItem score = b.getParcelable("score");
        setContentView(R.layout.activity_score);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        final ScoreAdapter scoreAdapter = new ScoreAdapter(score, getSupportFragmentManager());
        pager.setAdapter(scoreAdapter);

        HiscoresApplication.shmupAPI.getGame(score.getGame().getId(), new Callback<Game>() {
            @Override
            public void success(Game game, Response response) {
                scoreAdapter.setGame(game);
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.e(error, "Unable to fetch game");
            }
        });
        getSupportActionBar().setTitle(score.getGame().getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

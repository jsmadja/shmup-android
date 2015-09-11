package com.shmup.hiscores.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.shmup.hiscores.HiscoresApplication;
import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.adapter.ScoreCardAdapter;
import com.shmup.hiscores.scores.model.ScoreCardItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView timelineListView = (ListView) findViewById(R.id.timelineListView);
        ScoreCardAdapter adapter = new ScoreCardAdapter(this);
        timelineListView.setAdapter(adapter);
        HiscoresApplication.shmupAPI.getTimeline(fetchTimeline(adapter));
    }

    @NonNull
    private Callback<List<ScoreCardItem>> fetchTimeline(final ScoreCardAdapter adapter) {
        return new Callback<List<ScoreCardItem>>() {
            @Override
            public void success(List<ScoreCardItem> scoreCardItems, Response response) {
                adapter.setItems(scoreCardItems);
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.e(error, "Unable to fetch timeline");
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new_score) {
            startActivity(new Intent(this, CreateScoreActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

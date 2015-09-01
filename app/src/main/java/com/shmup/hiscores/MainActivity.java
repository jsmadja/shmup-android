package com.shmup.hiscores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.shmup.hiscores.scores.adapter.TimelineAdapter;
import com.shmup.hiscores.scores.model.TimelineItem;

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
        final TimelineAdapter adapter = new TimelineAdapter(this);
        timelineListView.setAdapter(adapter);
        HiscoresApplication.shmupAPI.getTimeline(new Callback<List<TimelineItem>>() {
            @Override
            public void success(List<TimelineItem> timelineItems, Response response) {
                adapter.setItems(timelineItems);
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.e(error, "Unable to fetch timeline ");
            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

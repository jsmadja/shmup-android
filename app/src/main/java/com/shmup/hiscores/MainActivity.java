package com.shmup.hiscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.shmup.hiscores.scores.adapter.TimelineAdapter;
import com.shmup.hiscores.scores.model.Player;
import com.shmup.hiscores.scores.model.Score;
import com.shmup.hiscores.scores.model.TimelineItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView timelineListView = (ListView) findViewById(R.id.timelineListView);
        timelineListView.setAdapter(new TimelineAdapter(new ArrayList<TimelineItem>() {{
            add(new TimelineItem(new Score(13L), new Player("juju")));
            add(new TimelineItem(new Score(14L), new Player("blacroix")));
            add(new TimelineItem(new Score(15L), new Player("tguerin")));
        }}, this));
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

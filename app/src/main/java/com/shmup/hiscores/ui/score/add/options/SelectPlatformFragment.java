package com.shmup.hiscores.ui.score.add.options;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.adapter.OptionAdapter;
import com.shmup.hiscores.games.model.Game;
import com.shmup.hiscores.games.model.Platform;
import com.shmup.hiscores.scores.view.ScoreCardItemView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

import static com.shmup.hiscores.HiscoresApplication.shmupAPI;
import static com.shmup.hiscores.R.id.platformsListView;
import static com.shmup.hiscores.R.layout.fragment_select_platform;
import static com.shmup.hiscores.R.string.title_select_platform;

public class SelectPlatformFragment extends SelectFragment<Platform> {

    public SelectPlatformFragment() {
        super(fragment_select_platform, title_select_platform, platformsListView);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shmupAPI.getGame(getItem().getGame().getId(), fetchGameDetail(getAdapter()));
    }

    @Override
    protected List<Platform> getOptions() {
        return new ArrayList<>();
    }

    @Override
    protected void populateItemWith(Platform platform) {
        getItem().setPlatform(platform);
    }

    @NonNull
    private Callback<Game> fetchGameDetail(final OptionAdapter<Platform> adapter) {
        return new Callback<Game>() {
            @Override
            public void success(Game game, Response response) {
                getItem().setGame(game);
                adapter.setOptions(game.getPlatforms());
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.e(error, "Unable to fetch game detail");
            }
        };
    }

}

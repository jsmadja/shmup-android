package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shmup.hiscores.HiscoresApplication;
import com.shmup.hiscores.R;
import com.shmup.hiscores.games.adapter.PlatformAdapter;
import com.shmup.hiscores.games.model.Game;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

import static com.shmup.hiscores.ui.score.add.NextItemFragmentFactory.nextFragmentOf;

public class SelectPlatformFragment extends ItemFragment {

    public SelectPlatformFragment() {
        super(R.layout.fragment_select_platform);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView platformsListView = (ListView) view.findViewById(R.id.platformsListView);
        final PlatformAdapter adapter = new PlatformAdapter(view.getContext());
        platformsListView.setAdapter(adapter);
        HiscoresApplication.shmupAPI.getGame(getItem().getGame().getId(), fetchGameDetail(adapter));
        platformsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setPlatform(adapter.getItem(position));
                goToSelectMode();
            }
        });
    }

    private void goToSelectMode() {
        getActivity().
                getSupportFragmentManager().
                beginTransaction().
                addToBackStack(SelectPlatformFragment.class.getSimpleName()).
                replace(R.id.container_view, nextFragmentOf(this)).
                commit();
    }

    @NonNull
    private Callback<Game> fetchGameDetail(final PlatformAdapter adapter) {
        return new Callback<Game>() {
            @Override
            public void success(Game game, Response response) {
                getItem().setGame(game);
                adapter.setPlatforms(game.getPlatforms());
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.e(error, "Unable to fetch game detail");
            }
        };
    }

}

package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shmup.hiscores.HiscoresApplication;
import com.shmup.hiscores.R;
import com.shmup.hiscores.activity.CreateScoreActivity;
import com.shmup.hiscores.games.adapter.OptionAdapter;
import com.shmup.hiscores.games.model.Game;
import com.shmup.hiscores.games.model.Platform;
import com.shmup.hiscores.games.view.PlatformItemView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public class SelectPlatformFragment extends ItemFragment {

    public SelectPlatformFragment() {
        super(R.layout.fragment_select_platform);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CreateScoreActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.title_select_platform));

        ListView platformsListView = (ListView) view.findViewById(R.id.platformsListView);
        OptionAdapter<Platform, PlatformItemView> adapter = new OptionAdapter<>(view.getContext(), R.layout.itemview_platform);
        platformsListView.setAdapter(adapter);
        HiscoresApplication.shmupAPI.getGame(getItem().getGame().getId(), fetchGameDetail(adapter));
        platformsListView.setOnItemClickListener(selectPlatform(adapter));
    }

    @NonNull
    private AdapterView.OnItemClickListener selectPlatform(final OptionAdapter<Platform, PlatformItemView> adapter) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setPlatform(adapter.getItem(position));
                goToNextFragmentFrom(SelectPlatformFragment.class);
            }
        };
    }

    @NonNull
    private Callback<Game> fetchGameDetail(final OptionAdapter<Platform, PlatformItemView> adapter) {
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

package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shmup.hiscores.R;
import com.shmup.hiscores.activity.CreateScoreActivity;
import com.shmup.hiscores.games.adapter.GameAdapter;
import com.shmup.hiscores.games.model.Game;
import com.shmup.hiscores.listener.RecyclerItemClickListener;
import com.shmup.hiscores.scores.model.ScoreCardItem;
import com.shmup.hiscores.ui.score.add.options.SelectPlatformFragment;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

import static com.shmup.hiscores.HiscoresApplication.shmupAPI;

public class SelectGameFragment extends Fragment {

    private ScoreCardItem item = new ScoreCardItem();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choose_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CreateScoreActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.title_select_game));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        GameAdapter adapter = new GameAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(selectGame(view, adapter));
        shmupAPI.getGameList(fetchGames(adapter));
    }

    @NonNull
    private Callback<List<Game>> fetchGames(final GameAdapter adapter) {
        return new Callback<List<Game>>() {
            @Override
            public void success(List<Game> games, Response response) {
                adapter.setGames(games);
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.e(error, "Unable to fetch game list");
            }
        };
    }

    @NonNull
    private RecyclerItemClickListener selectGame(View view, final GameAdapter adapter) {
        return new RecyclerItemClickListener(view.getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                item.setGame(adapter.getGameAt(position));
                goToNextFragment();
            }
        });
    }

    private void goToNextFragment() {
        getActivity().getSupportFragmentManager().
                beginTransaction().
                addToBackStack(SelectGameFragment.class.getSimpleName()).
                replace(R.id.container_view, ItemFragment.newInstance(item, SelectPlatformFragment.class)).
                commit();
    }
}

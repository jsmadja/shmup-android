package com.shmup.hiscores.ui.score.read;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.model.Ranking;
import com.shmup.hiscores.games.adapter.RankingScoreAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class RankingFragment extends Fragment {

    public static final String RANKING = "ranking";

    @Bind(R.id.modeTextView) TextView modeTextView;
    @Bind(R.id.difficultyTextView) TextView difficultyTextView;

    public static Fragment newInstance(Ranking ranking) {
        Fragment fragment = new RankingFragment();
        Bundle args = new Bundle();
        args.putParcelable(RANKING, ranking);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Ranking ranking = getArguments().getParcelable(RANKING);
        if (ranking.getMode() == null) {
            modeTextView.setVisibility(GONE);
        } else {
            modeTextView.setText(ranking.getMode().getName());
            modeTextView.setVisibility(VISIBLE);
        }
        if (ranking.getDifficulty() == null) {
            difficultyTextView.setVisibility(GONE);
        } else {
            difficultyTextView.setText(ranking.getDifficulty().getName());
            difficultyTextView.setVisibility(VISIBLE);
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        RankingScoreAdapter adapter = new RankingScoreAdapter(ranking.getScores());
        recyclerView.setAdapter(adapter);
    }
}

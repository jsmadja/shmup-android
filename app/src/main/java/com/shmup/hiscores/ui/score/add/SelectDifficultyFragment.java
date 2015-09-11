package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.activity.CreateScoreActivity;
import com.shmup.hiscores.games.adapter.OptionAdapter;
import com.shmup.hiscores.games.model.Difficulty;
import com.shmup.hiscores.games.view.DifficultyItemView;

public class SelectDifficultyFragment extends ItemFragment {

    public SelectDifficultyFragment() {
        super(R.layout.fragment_select_difficulty);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CreateScoreActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.title_select_difficulty));

        ListView difficultiesListView = (ListView) view.findViewById(R.id.difficultiesListView);
        OptionAdapter<Difficulty, DifficultyItemView> adapter = new OptionAdapter<>(view.getContext(), R.layout.itemview_difficulty);
        adapter.setOptions(getItem().getGame().getDifficulties());
        difficultiesListView.setAdapter(adapter);
        difficultiesListView.setOnItemClickListener(selectDifficulty(adapter));
    }

    @NonNull
    private AdapterView.OnItemClickListener selectDifficulty(final OptionAdapter<Difficulty, DifficultyItemView> adapter) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setDifficulty(adapter.getItem(position));
                goToNextFragmentFrom(SelectDifficultyFragment.class);
            }
        };
    }

}

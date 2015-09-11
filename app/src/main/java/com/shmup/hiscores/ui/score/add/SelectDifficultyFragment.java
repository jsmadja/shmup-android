package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.adapter.OptionAdapter;
import com.shmup.hiscores.scores.model.Difficulty;
import com.shmup.hiscores.scores.view.DifficultyItemView;

import static com.shmup.hiscores.ui.score.add.NextItemFragmentFactory.nextFragmentOf;

public class SelectDifficultyFragment extends ItemFragment {

    public SelectDifficultyFragment() {
        super(R.layout.fragment_select_difficulty);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView difficultiesListView = (ListView) view.findViewById(R.id.difficultiesListView);
        final OptionAdapter<Difficulty, DifficultyItemView> adapter = new OptionAdapter(view.getContext(), R.layout.itemview_difficulty);
        adapter.setOptions(getItem().getGame().getDifficulties());
        difficultiesListView.setAdapter(adapter);
        difficultiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setDifficulty(adapter.getItem(position));
                goToSelectShip();
            }
        });
    }

    private void goToSelectShip() {
        getActivity().getSupportFragmentManager().
                beginTransaction().
                addToBackStack(SelectDifficultyFragment.class.getSimpleName()).
                replace(R.id.container_view, nextFragmentOf(this)).
                commit();
    }

}

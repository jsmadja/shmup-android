package com.shmup.hiscores.ui.score.add.options;

import com.shmup.hiscores.games.model.Difficulty;

import java.util.List;

import static com.shmup.hiscores.R.id.difficultiesListView;
import static com.shmup.hiscores.R.layout.fragment_select_difficulty;
import static com.shmup.hiscores.R.string.title_select_difficulty;

public class SelectDifficultyFragment extends SelectFragment<Difficulty> {

    public SelectDifficultyFragment() {
        super(fragment_select_difficulty, title_select_difficulty, difficultiesListView);
    }

    @Override
    protected List<Difficulty> getOptions() {
        return getItem().getGame().getDifficulties();
    }

    @Override
    protected void populateItemWith(Difficulty difficulty) {
        getItem().setDifficulty(difficulty);
    }
}

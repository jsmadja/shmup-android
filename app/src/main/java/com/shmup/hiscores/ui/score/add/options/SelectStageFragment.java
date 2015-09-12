package com.shmup.hiscores.ui.score.add.options;

import com.shmup.hiscores.games.model.Stage;

import java.util.List;

import static com.shmup.hiscores.R.id.stagesListView;
import static com.shmup.hiscores.R.layout.fragment_select_stage;
import static com.shmup.hiscores.R.string.title_select_stage;

public class SelectStageFragment extends SelectFragment<Stage> {

    public SelectStageFragment() {
        super(fragment_select_stage, title_select_stage, stagesListView);
    }

    @Override
    protected List<Stage> getOptions() {
        return getItem().getGame().getStages();
    }

    @Override
    protected void populateItemWith(Stage stage) {
        getItem().setStage(stage);
    }
}

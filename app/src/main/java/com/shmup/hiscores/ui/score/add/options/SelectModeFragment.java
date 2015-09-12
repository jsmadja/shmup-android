package com.shmup.hiscores.ui.score.add.options;

import com.shmup.hiscores.games.model.Mode;

import java.util.List;

import static com.shmup.hiscores.R.id.modesListView;
import static com.shmup.hiscores.R.layout.fragment_select_mode;
import static com.shmup.hiscores.R.string.title_select_mode;

public class SelectModeFragment extends SelectFragment<Mode> {

    public SelectModeFragment() {
        super(fragment_select_mode, title_select_mode, modesListView);
    }

    @Override
    protected List<Mode> getOptions() {
        return getItem().getGame().getModes();
    }

    @Override
    protected void populateItemWith(Mode option) {
        getItem().setMode(option);
    }
}

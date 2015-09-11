package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.adapter.OptionAdapter;
import com.shmup.hiscores.scores.model.Mode;
import com.shmup.hiscores.scores.view.ModeItemView;

import static com.shmup.hiscores.ui.score.add.NextItemFragmentFactory.nextFragmentOf;

public class SelectModeFragment extends ItemFragment {

    public SelectModeFragment() {
        super(R.layout.fragment_select_mode);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView platformsListView = (ListView) view.findViewById(R.id.modesListView);
        final OptionAdapter<Mode, ModeItemView> adapter = new OptionAdapter(view.getContext(), R.layout.itemview_mode);
        adapter.setOptions(getItem().getGame().getModes());
        platformsListView.setAdapter(adapter);
        platformsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setMode(adapter.getItem(position));
                goToSelectDifficulty();
            }
        });
    }

    private void goToSelectDifficulty() {
        getActivity().getSupportFragmentManager().
                beginTransaction().
                addToBackStack(SelectModeFragment.class.getSimpleName()).
                replace(R.id.container_view, nextFragmentOf(this)).commit();
    }

}

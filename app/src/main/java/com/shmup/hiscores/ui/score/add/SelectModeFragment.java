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
import com.shmup.hiscores.games.model.Mode;
import com.shmup.hiscores.games.view.ModeItemView;

public class SelectModeFragment extends ItemFragment {

    public SelectModeFragment() {
        super(R.layout.fragment_select_mode);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CreateScoreActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.title_select_mode));

        ListView platformsListView = (ListView) view.findViewById(R.id.modesListView);
        OptionAdapter<Mode, ModeItemView> adapter = new OptionAdapter<>(view.getContext(), R.layout.itemview_mode);
        adapter.setOptions(getItem().getGame().getModes());
        platformsListView.setAdapter(adapter);
        platformsListView.setOnItemClickListener(selectMode(adapter));
    }

    @NonNull
    private AdapterView.OnItemClickListener selectMode(final OptionAdapter<Mode, ModeItemView> adapter) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setMode(adapter.getItem(position));
                goToNextFragmentFrom(SelectModeFragment.class);
            }
        };
    }

}

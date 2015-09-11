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
import com.shmup.hiscores.games.model.Stage;
import com.shmup.hiscores.games.view.StageItemView;

public class SelectStageFragment extends ItemFragment {

    public SelectStageFragment() {
        super(R.layout.fragment_select_stage);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CreateScoreActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.title_select_stage));

        ListView stagesListView = (ListView) view.findViewById(R.id.stagesListView);
        OptionAdapter<Stage, StageItemView> adapter = new OptionAdapter<>(view.getContext(), R.layout.itemview_stage);
        adapter.setOptions(getItem().getGame().getStages());
        stagesListView.setAdapter(adapter);
        stagesListView.setOnItemClickListener(selectStage(adapter));
    }

    @NonNull
    private AdapterView.OnItemClickListener selectStage(final OptionAdapter<Stage, StageItemView> adapter) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setStage(adapter.getItem(position));
                goToNextFragment();
            }
        };
    }

    private void goToNextFragment() {
        System.err.println("go enter score!");
    }
}

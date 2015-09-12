package com.shmup.hiscores.ui.score.add.options;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.activity.CreateScoreActivity;
import com.shmup.hiscores.games.adapter.OptionAdapter;
import com.shmup.hiscores.games.model.Option;
import com.shmup.hiscores.scores.view.ScoreCardItemView;
import com.shmup.hiscores.ui.score.add.ItemFragment;

import java.util.List;

public abstract class SelectFragment<O extends Option> extends ItemFragment {

    private int titleId;
    private int listViewId;
    private OptionAdapter<O> adapter;

    public SelectFragment(int layoutId, int titleId, int listViewId) {
        super(layoutId);
        this.titleId = titleId;
        this.listViewId = listViewId;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CreateScoreActivity) getActivity()).setActionBarTitle(getResources().getString(titleId));

        ListView listView = (ListView) view.findViewById(this.listViewId);
        adapter = new OptionAdapter<>(view.getContext());
        adapter.setOptions(getOptions());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(select(adapter));

        ((ScoreCardItemView) view.findViewById(R.id.preview)).bindView(getItem());
    }


    private AdapterView.OnItemClickListener select(final OptionAdapter<O> adapter) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                populateItemWith(adapter.getItem(position));
                goToNextFragmentFrom(SelectFragment.this.getClass());
            }
        };
    }

    protected abstract List<O> getOptions();

    protected abstract void populateItemWith(O option);

    protected OptionAdapter<O> getAdapter() {
        return adapter;
    }

}

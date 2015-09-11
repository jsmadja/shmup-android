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
import com.shmup.hiscores.games.model.Ship;
import com.shmup.hiscores.games.view.ShipItemView;

public class SelectShipFragment extends ItemFragment {

    public SelectShipFragment() {
        super(R.layout.fragment_select_ship);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CreateScoreActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.title_select_ship));

        ListView shipsListView = (ListView) view.findViewById(R.id.shipsListView);
        OptionAdapter<Ship, ShipItemView> adapter = new OptionAdapter<>(view.getContext(), R.layout.itemview_ship);
        adapter.setOptions(getItem().getGame().getShips());
        shipsListView.setAdapter(adapter);
        shipsListView.setOnItemClickListener(selectShip(adapter));
    }

    @NonNull
    private AdapterView.OnItemClickListener selectShip(final OptionAdapter<Ship, ShipItemView> adapter) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setShip(adapter.getItem(position));
                goToNextFragmentFrom(SelectShipFragment.class);
            }
        };
    }

}

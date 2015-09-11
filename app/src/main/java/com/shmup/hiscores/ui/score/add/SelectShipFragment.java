package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.games.adapter.OptionAdapter;
import com.shmup.hiscores.scores.model.Ship;
import com.shmup.hiscores.scores.view.ShipItemView;

public class SelectShipFragment extends ItemFragment {

    public SelectShipFragment() {
        super(R.layout.fragment_select_ship);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView shipsListView = (ListView) view.findViewById(R.id.shipsListView);
        final OptionAdapter<Ship, ShipItemView> adapter = new OptionAdapter(view.getContext(), R.layout.itemview_ship);
        adapter.setOptions(getItem().getGame().getShips());
        shipsListView.setAdapter(adapter);
        shipsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItem().setShip(adapter.getItem(position));
                goToEnterScore();
            }
        });
    }

    private void goToEnterScore() {
        System.err.println("go enter score!");
    }
}

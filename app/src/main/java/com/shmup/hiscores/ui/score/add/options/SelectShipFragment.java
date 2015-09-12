package com.shmup.hiscores.ui.score.add.options;

import com.shmup.hiscores.games.model.Ship;

import java.util.List;

import static com.shmup.hiscores.R.id.shipsListView;
import static com.shmup.hiscores.R.layout.fragment_select_ship;
import static com.shmup.hiscores.R.string.title_select_ship;

public class SelectShipFragment extends SelectFragment<Ship> {

    public SelectShipFragment() {
        super(fragment_select_ship, title_select_ship, shipsListView);
    }

    @Override
    protected List<Ship> getOptions() {
        return getItem().getGame().getShips();
    }

    @Override
    protected void populateItemWith(Ship ship) {
        getItem().setShip(ship);
    }
}

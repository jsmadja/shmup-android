package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.Game;
import com.shmup.hiscores.scores.model.TimelineItem;

public class ChooseGameFragment extends Fragment {

    private TimelineItem item = new TimelineItem();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choose_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View button = view.findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setGame(new Game(12, "My Game"));
                getActivity().getSupportFragmentManager().
                        beginTransaction().
                        addToBackStack(ChooseGameFragment.class.getSimpleName()).
                        replace(R.id.container_view, EnterScoreFragment.newInstance(item)).
                        commit();
            }
        });
    }
}

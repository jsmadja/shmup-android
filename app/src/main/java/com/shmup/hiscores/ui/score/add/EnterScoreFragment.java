package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.view.ScoreCardItemView;

public class EnterScoreFragment extends ItemFragment {

    public EnterScoreFragment() {
        super(R.layout.fragment_enter_score);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ((ScoreCardItemView) view.findViewById(R.id.preview)).bindView(getItem());
        return view;
    }
}

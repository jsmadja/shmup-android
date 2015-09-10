package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.TimelineItem;

public class EnterScoreFragment extends Fragment {

    public static final String ITEM_KEY = "item";
    private TimelineItem item;

    public static EnterScoreFragment newInstance(TimelineItem item) {
        Bundle args = new Bundle();
        args.putParcelable(ITEM_KEY, item);
        EnterScoreFragment fragment = new EnterScoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = (TimelineItem) getArguments().getParcelable(ITEM_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter_score, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView gameTextView = (TextView) view.findViewById(R.id.gameTextView);
        gameTextView.setText(item.getGame().getTitle());
    }
}

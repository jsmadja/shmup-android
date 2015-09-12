package com.shmup.hiscores.ui.score.read;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.ScoreCardItem;
import com.shmup.hiscores.scores.view.ScoreCardItemView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ScoreFragment extends Fragment {

    public static final String SCORE = "score";

    @Bind(R.id.photoImageView) ImageView photoImageView;

    public static Fragment newInstance(ScoreCardItem score) {
        Fragment fragment = new ScoreFragment();
        Bundle args = new Bundle();
        args.putParcelable(SCORE, score);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ScoreCardItem score = getArguments().getParcelable(SCORE);
        ((ScoreCardItemView) view.findViewById(R.id.preview)).bindView(score);
        String photo = score.getPhoto();
        if (photo == null) {
            photoImageView.setVisibility(GONE);
        } else {
            photoImageView.setVisibility(VISIBLE);
            Picasso.with(view.getContext()).load(photo).into(photoImageView);
        }

    }
}

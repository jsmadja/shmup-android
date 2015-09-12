package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.shmup.hiscores.R;
import com.shmup.hiscores.activity.CreateScoreActivity;
import com.shmup.hiscores.scores.view.ScoreCardItemView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TypeScoreFragment extends ItemFragment {

    public TypeScoreFragment() {
        super(R.layout.fragment_type_score);
    }

    @Bind(R.id.scoreEditText) EditText scoreEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ((ScoreCardItemView) view.findViewById(R.id.preview)).bindView(getItem());
        ((CreateScoreActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.title_enter_score));
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        scoreEditText.setOnEditorActionListener(goToNextFragment());
    }

    @NonNull
    private TextView.OnEditorActionListener goToNextFragment() {
        return new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND || actionId == MotionEvent.ACTION_DOWN) {
                    handled = true;
                    getItem().setScore(Long.valueOf(v.getText().toString()));
                    getActivity().getSupportFragmentManager().
                            beginTransaction().
                            addToBackStack(TypeScoreFragment.class.getSimpleName()).
                            replace(R.id.container_view, ItemFragment.newInstance(getItem(), TypeCommentFragment.class)).
                            commit();
                }
                return handled;
            }
        };
    }

}
